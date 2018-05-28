package my.dg.fragments;

import android.app.Fragment;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import my.dg.R;

/**
 * Created by Domenico Grasso on 10/08/2017
 */

public class AlphaAnimationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.alpha_animation_fragment, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView mImgCheck = (ImageView) getView().findViewById(R.id.imageView);
        ((Animatable) mImgCheck.getDrawable()).start();
    }

}
