package it.dg.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.dg.R;
import it.dg.parallax.ParallaxRecycleView;
import it.dg.parallaxfragmentcomponents.ImageViewAdapter;

/**
 * Created by Domenico Grasso on 09/08/2017
 */

public class ParallaxFragment extends Fragment {

    View view;
    ParallaxRecycleView list;
    Context context;

    public ParallaxFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.parallax_fragment, container, false);
        xmlReferences();
        return view;
    }

    private void xmlReferences() {
        list = (ParallaxRecycleView) view.findViewById(R.id.recyclerView);
        list.setLayoutManager(new LinearLayoutManager(context));
        list.setAdapter(new ImageViewAdapter(context));
    }
}
