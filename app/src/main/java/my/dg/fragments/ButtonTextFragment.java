package my.dg.fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import my.dg.R;

/**
 * Created by Domenico Grasso on 01/08/2017
 */

public class ButtonTextFragment extends Fragment {
    private Button button;
    private TextView text;
    private ViewGroup transitionsContainer;
    private View view;

    public ButtonTextFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.button_text_layout, container, false);
        xmlReferences();
        setListener();
        return view;
    }

    private void setListener() {
        button.setOnClickListener(new View.OnClickListener() {
            boolean visible;

            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(transitionsContainer);
                }
                visible = !visible;
                text.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
    }

    private void xmlReferences() {
        button = (Button) view.findViewById(R.id.button);
        text = (TextView) view.findViewById(R.id.testo);
        transitionsContainer = (ViewGroup) view.findViewById(R.id.transitions_container);
    }
}
