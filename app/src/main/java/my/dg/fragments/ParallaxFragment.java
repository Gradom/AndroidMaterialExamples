package my.dg.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import my.dg.R;
import my.dg.parallax.ParallaxRecycleView;
import my.dg.parallaxfragmentcomponents.ImageViewAdapter;

/**
 * Created by Domenico Grasso on 09/08/2017
 */

public class ParallaxFragment extends Fragment {

    View view;
    ParallaxRecycleView list;
    Context context;

    public ParallaxFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.parallax_fragment, container, false);
        context = container.getContext();
        xmlReferences();
        return view;
    }

    private void xmlReferences() {
        list = (ParallaxRecycleView) view.findViewById(R.id.recyclerView);
        list.setLayoutManager(new LinearLayoutManager(context));
        list.setAdapter(new ImageViewAdapter(context));
    }
}
