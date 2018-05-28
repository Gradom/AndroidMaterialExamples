package my.dg.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import my.dg.R;

/**
 * Created by Domenico Grasso on 25/05/2018
 */
public class ChainSpringAnimationFragment extends Fragment {
    private int delta;
    int actionBarSize = 0;
    int y;
    int x;
    SpringAnimation animY;
    SpringAnimation animX;
    SpringAnimation anim2X;
    SpringAnimation anim2Y;
    SpringAnimation anim3X;
    SpringAnimation anim3Y;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chain_spring_fragment, container, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final LinearLayout spring = view.findViewById(R.id.spring_chain_layout1);
        final LinearLayout spring2 = view.findViewById(R.id.spring_chain_layout2);
        final LinearLayout spring3 = view.findViewById(R.id.spring_chain_layout3);
        TypedArray styledAttributes = view.getContext().getTheme().obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        if (styledAttributes != null) {
            actionBarSize = (int) styledAttributes.getDimension(0, 0);
            styledAttributes.recycle();
        }
        animY = new SpringAnimation(spring, DynamicAnimation.Y);
        animX = new SpringAnimation(spring, DynamicAnimation.X);
        setSpringHigh(animX);
        setSpringHigh(animY);
        anim2X = new SpringAnimation(spring2, DynamicAnimation.X);
        anim2Y = new SpringAnimation(spring2, DynamicAnimation.Y);
        setSpringMediaum(anim2X);
        setSpringMediaum(anim2Y);
        anim3X = new SpringAnimation(spring3, DynamicAnimation.X);
        anim3Y = new SpringAnimation(spring3, DynamicAnimation.Y);
        setSpringLow(anim3X);
        setSpringLow(anim3Y);

        animX.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                anim2X.animateToFinalPosition(value);
                anim3X.animateToFinalPosition(value);
            }
        });
        animY.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
            @Override
            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                anim2Y.animateToFinalPosition(value+spring2.getHeight());
                anim3Y.animateToFinalPosition(value+spring2.getHeight());
            }
        });
        animY.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                anim2Y.animateToFinalPosition(value+spring2.getTop());
                anim3Y.animateToFinalPosition(value+spring3.getTop());
            }
        });

        spring.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                y = (int) motionEvent.getRawY();
                x = (int) motionEvent.getRawX();
                delta = y - actionBarSize;
                int action = motionEvent.getAction();
                switch (action) {
                    case MotionEvent.ACTION_MOVE:
                        animX.animateToFinalPosition(x);
                        animY.animateToFinalPosition(delta);
                        break;
                }
                view.invalidate();
                return true;
            }
        });
    }

    private void setSpringHigh(SpringAnimation anim) {
        anim.setSpring(new SpringForce());
     //   anim.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
        anim.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY);
    }

    private void setSpringMediaum(SpringAnimation anim) {
        anim.setSpring(new SpringForce());
        anim.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
        anim.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
    }

    private void setSpringLow(SpringAnimation anim) {
        anim.setSpring(new SpringForce());
        anim.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
        anim.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY);
    }
}
