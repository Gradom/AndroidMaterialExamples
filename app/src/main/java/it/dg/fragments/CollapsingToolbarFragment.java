package it.dg.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.dg.R;

/**
 * Created by Domenico Grasso on 09/08/2017
 */

public class CollapsingToolbarFragment extends Fragment {

    View view;
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.collapsing_toolbar_fragment, container, false);
        xmlReferences();
        return view;
    }

    private void xmlReferences() {
        collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Titolo");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.rosso));
        collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.square_motion_background));
    }

}
