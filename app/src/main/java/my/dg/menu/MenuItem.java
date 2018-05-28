package my.dg.menu;

import android.app.Fragment;

/**
 * Created by Domenico Grasso on 01/08/2017
 */

public class MenuItem {

    private String label;
    private Fragment fragment;

    public MenuItem(String label, Fragment fragment) {
        this.label = label;
        this.fragment = fragment;
    }

    public String getLabel() {
        return label;
    }

    public Fragment getFragment() {
        return fragment;
    }

}