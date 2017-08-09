package it.dg.fragments;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;

import it.dg.R;

/**
 * Created by Domenico Grasso on 03/08/2017
 */

public class CurvedMotionFragment extends Fragment {

    private View view;
    private LinearLayout square;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.curved_motion_fragment, container, false);
        xmlReferences();
        setListeners();
        return view;
    }

    private void setListeners() {
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    PathInterpolator interpolator = new PathInterpolator(0.4f, 0, 1, 1);
                    Path path = new Path();
                    path.moveTo(1, 1);
                    path.lineTo(view.getWidth() - square.getWidth(), view.getHeight() - square.getHeight());
                    ObjectAnimator animator = ObjectAnimator.ofFloat(square, View.TRANSLATION_X, View.TRANSLATION_Y, path);
                    animator.setInterpolator(interpolator);
                    animator.setDuration(3000);
                    animator.start();
                }
            }
        });
    }

    private void xmlReferences() {
        square = (LinearLayout) view.findViewById(R.id.square_motion);
    }
}
