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
 * Created by Domenico Grasso on 24/05/2018
 */
public class AnimatedIconAdvancedFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.icon_advanced_animation_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView mImgCheck =  getView().findViewById(R.id.imageView_advanced);
        ((Animatable) mImgCheck.getDrawable()).start();
    }
}
