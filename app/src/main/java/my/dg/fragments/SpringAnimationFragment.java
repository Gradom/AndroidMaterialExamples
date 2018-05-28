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
public class SpringAnimationFragment extends Fragment {

    private int delta;
    int actionBarSize = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.spring_animation_fragment, container, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final LinearLayout spring = view.findViewById(R.id.spring_layout);
        TypedArray styledAttributes = view.getContext().getTheme().obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        if (styledAttributes != null) {
            actionBarSize = (int) styledAttributes.getDimension(0, 0);
            styledAttributes.recycle();
        }
        spring.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int y = (int) motionEvent.getRawY();
                delta = y - actionBarSize;
                int action = motionEvent.getAction();
                switch (action) {
                    case MotionEvent.ACTION_MOVE:
                        view.setY(delta);
                        break;
                    case MotionEvent.ACTION_UP:
                        SpringAnimation anim = new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y, 0).setStartVelocity(1000);
                        anim.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
                        anim.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
                        anim.start();
                        break;
                }
                view.invalidate();
                return true;
            }
        });


    }
}
