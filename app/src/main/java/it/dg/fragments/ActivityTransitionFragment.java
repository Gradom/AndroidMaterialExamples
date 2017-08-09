package it.dg.fragments;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import it.dg.R;
import it.dg.activities.ResultActivity;

/**
 * Created by Domenico Grasso on 02/08/2017
 */

public class ActivityTransitionFragment extends Fragment {
    private View view;
    private Button newActivity, newActivityWithView;
    private Context context;
    private Activity activity;
    private ImageView imageToShare;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_transition_fragment, container, false);
        if (context == null) {
            context = inflater.getContext();
            activity = ((Activity) context);
        }
        xmlReferences();
        setListeners();

        return view;
    }

    private void setListeners() {
        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(new Intent(context, ResultActivity.class), ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
                } else {
                    startActivity(new Intent(context, ResultActivity.class));
                }
            }
        });

        newActivityWithView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(new Intent(context, ResultActivity.class), ActivityOptions.makeSceneTransitionAnimation(activity, imageToShare, "imageToShare").toBundle());
                } else {
                    startActivity(new Intent(context, ResultActivity.class));
                }
            }
        });
    }

    private void xmlReferences() {
        newActivity = (Button) view.findViewById(R.id.activity_transition_fragment_button);
        newActivityWithView = (Button) view.findViewById(R.id.activity_transition_fragment_shared_element);
        imageToShare = (ImageView) view.findViewById(R.id.view_to_share);
    }
}
