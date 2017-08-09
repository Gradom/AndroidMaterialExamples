package it.dg.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.dg.R;

/**
 * Created by Domenico Grasso on 08/08/2017
 */

public class EditTextTransitionFargment extends Fragment {


    private View view;
    private TextInputEditText nome, cognome, nick, data;
    private TextInputLayout nomeLayout, cognomeLayout, nickLayout, dataLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.edittext_trasition_fragment, container, false);
        xmlReferences();
        enableErrors();
        return view;
    }

    private void enableErrors() {
        cognomeLayout.setError("Errore");
    }

    private void xmlReferences() {
        nome = (TextInputEditText) view.findViewById(R.id.input_name);
        cognome = (TextInputEditText) view.findViewById(R.id.input_cognome);
        nick = (TextInputEditText) view.findViewById(R.id.input_nick);
        data = (TextInputEditText) view.findViewById(R.id.input_data);

        nomeLayout = (TextInputLayout) view.findViewById(R.id.input_layout_name);
        cognomeLayout = (TextInputLayout) view.findViewById(R.id.input_layout_cognome);
        nickLayout = (TextInputLayout) view.findViewById(R.id.input_layout_nick);
        dataLayout = (TextInputLayout) view.findViewById(R.id.input_layout_data);
    }
}
