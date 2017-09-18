package my.dg.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import my.dg.R;

/**
 * Created by Domenico Grasso on 02/08/2017
 */

public class CircularAnimationFragment extends Fragment {

    private ImageView image;
    private View view;
    private ToggleButton toggleButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.circular_animation_fragment, container, false);
        xmlReferences();
        return view;
    }

    private void xmlReferences() {
        image = (ImageView) view.findViewById(R.id.image);
        toggleButton = (ToggleButton) view.findViewById(R.id.toggle_button);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    show();
                } else {
                    hide();
                }
            }
        });
    }

    private void hide() {
        // get the center for the clipping circle
        int cx = image.getWidth() / 2;
        int cy = image.getHeight() / 2;

        // get the final radius for the clipping circle
        float finalRadius = Math.max(image.getWidth(), image.getHeight());

        // create the animator for this view (the start radius is zero)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            final Animator anim = ViewAnimationUtils.createCircularReveal(image, cx, cy, finalRadius, 0);
            // make the view visible and start the animation
            anim.setDuration(1000);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    image.setVisibility(View.INVISIBLE);

                }
            });
            anim.start();
        }
    }

    private void show() {
        // get the center for the clipping circle
        int cx = image.getWidth() / 2;
        int cy = image.getHeight() / 2;

        // get the final radius for the clipping circle
        float finalRadius = Math.max(image.getWidth(), image.getHeight());

        // create the animator for this view (the start radius is zero)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Animator anim = ViewAnimationUtils.createCircularReveal(image, cx, cy, 0, finalRadius);
            // make the view visible and start the animation
            anim.setDuration(1000);
            image.setVisibility(View.VISIBLE);
            anim.start();
        }
    }
}