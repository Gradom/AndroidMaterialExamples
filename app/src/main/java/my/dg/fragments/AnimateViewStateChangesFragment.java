package my.dg.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import my.dg.R;

/**
 * Created by Domenico Grasso on 07/08/2017
 */

public class AnimateViewStateChangesFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.animate_view_state_change_fragment, container, false);
    }

}
