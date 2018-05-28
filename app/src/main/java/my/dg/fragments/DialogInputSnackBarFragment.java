package my.dg.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import my.dg.R;
import my.dg.components.MaterialMessagePopUp;

/**
 * Created by Domenico Grasso on 30/11/2017
 */

public class DialogInputSnackBarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_snackbar_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        buttonUpListener();
    }

    private void buttonUpListener() {
        if (getView() != null) {
            Button upButton = (Button) getView().findViewById(R.id.show_up_message);
            if (upButton != null) {
                upButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new MaterialMessagePopUp().show(getFragmentManager(),"");
                    }
                });
            }
        }
    }
}
