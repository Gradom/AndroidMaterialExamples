package my.dg.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

import my.dg.R;

/**
 * Created by Domenico Grasso on 06/09/2017
 */

public class BoundChangeFragment extends Fragment {

    private View view;
    private LinearLayout bluLayout, redLayout, blackLayout;
    private View square;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.change_bound_fragment, container, false);
        xmlReferences();
        setListeners();
        return view;
    }

    private void setListeners() {
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Path path = new Path();
                path.moveTo(1, 1);
                path.lineTo(0, -(redLayout.getY() - bluLayout.getY()));
                ObjectAnimator animator = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    animator = ObjectAnimator.ofFloat(square, View.TRANSLATION_X, View.TRANSLATION_Y, path);
                }
                animator.setInterpolator(new AccelerateInterpolator());
                animator.setDuration(1500);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            final Animator anim = ViewAnimationUtils.createCircularReveal(blackLayout, blackLayout.getWidth() / 2, blackLayout.getHeight() / 2, 0, blackLayout.getWidth());
                            // make the view visible and start the animation
                            anim.setDuration(1000);
                            anim.addListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    square.setVisibility(View.GONE);

                                }
                            });
                            blackLayout.setVisibility(View.VISIBLE);
                            anim.start();
                        }
                    }
                });
                animator.start();
            }
        });

    }

    private void xmlReferences() {
        square = view.findViewById(R.id.black_square);
        bluLayout = (LinearLayout) view.findViewById(R.id.blu_layout);
        blackLayout = (LinearLayout) view.findViewById(R.id.black_layout);
        redLayout = (LinearLayout) view.findViewById(R.id.red_layout);
    }
}
