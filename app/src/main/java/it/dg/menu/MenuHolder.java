package it.dg.menu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import it.dg.R;

/**
 * Created by Domenico Grasso on 01/08/2017
 */

class MenuHolder extends RecyclerView.ViewHolder  {

    private TextView menuLabel;

    MenuHolder(View itemView) {
        super(itemView);
        menuLabel = (TextView) itemView.findViewById(R.id.menu_label);
    }

    void setMenuLabel(String label) {
        if (menuLabel != null) {
            menuLabel.setText(label);
        }
    }


}
