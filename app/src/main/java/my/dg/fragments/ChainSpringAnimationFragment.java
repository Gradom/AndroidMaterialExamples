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


        spring.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                y = (int) motionEvent.getRawY();
                x = (int) motionEvent.getRawX();
                delta = y - actionBarSize;
                int action = motionEvent.getAction();
                switch (action) {
                    case MotionEvent.ACTION_MOVE:
                        SpringAnimation anim = new SpringAnimation(view, DynamicAnimation.Y);
                        SpringAnimation animX = new SpringAnimation(view, DynamicAnimation.X);
                        anim.setSpring(new SpringForce());
                        anim.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
                        anim.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);

                        animX.setSpring(new SpringForce());
                        animX.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
                        animX.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
                        anim.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
                            @Override
                            public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                                SpringAnimation anim2 = new SpringAnimation(spring2, DynamicAnimation.Y);
//                                anim2.setStartVelocity(1000);
                                anim2.setSpring(new SpringForce());
                                anim2.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
                                anim2.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);

                                SpringAnimation anim2X = new SpringAnimation(spring2, DynamicAnimation.X);
//                        anim2X.setStartVelocity(1000);
                                anim2X.setSpring(new SpringForce());
                                anim2X.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
                                anim2X.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);


//                        SpringAnimation anim3 = new SpringAnimation(spring3, DynamicAnimation.Y).setStartVelocity(1000);
//                        anim3.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
//                        anim3.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
                                anim2.animateToFinalPosition(delta + spring2.getTop());
                                anim2X.animateToFinalPosition(x);
//                        anim3.animateToFinalPosition(delta);
                            }
                        });
                        anim.animateToFinalPosition(delta);
                        animX.animateToFinalPosition(x);

//                        view.setY(delta);
//                        view.setX(x);

                        break;
                    case MotionEvent.ACTION_UP:
//                        SpringAnimation anim = new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y, 0).setStartVelocity(1000);
//                        anim.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
//                        anim.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
//                        anim.start();
                        break;
                }
                view.invalidate();
                return true;
            }
        });
    }
}
