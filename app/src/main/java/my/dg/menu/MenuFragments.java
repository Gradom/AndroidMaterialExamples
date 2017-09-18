package my.dg.menu;


import java.util.ArrayList;
import java.util.List;

import my.dg.fragments.ActivityTransitionFragment;
import my.dg.fragments.AnimateViewStateChangesFragment;
import my.dg.fragments.BoundChangeFragment;
import my.dg.fragments.ButtonTextFragment;
import my.dg.fragments.CardsFragment;
import my.dg.fragments.CircularAnimationFragment;
import my.dg.fragments.CollapsingToolbarFragment;
import my.dg.fragments.CurvedMotionFragment;
import my.dg.fragments.EditTextTransitionFargment;
import my.dg.fragments.IntroFragment;
import my.dg.fragments.ParallaxFragment;
import my.dg.fragments.BlurFragment;

/**
 * Created by Domenico Grasso on 01/08/2017
 */

public class MenuFragments {

    private static MenuFragments instance;
    private static List<MenuItem> fragmentsList;

    public static MenuFragments getInstance() {
        if (instance == null) {
            fragmentsList = new ArrayList<>();
            instance = new MenuFragments();
        }
        return instance;
    }

    private MenuFragments() {
        fragmentsList.add(new MenuItem("Intro", new IntroFragment()));
        fragmentsList.add(new MenuItem("Text Transition", new ButtonTextFragment()));
        fragmentsList.add(new MenuItem("Circular animation", new CircularAnimationFragment()));
        fragmentsList.add(new MenuItem("Activity transition", new ActivityTransitionFragment()));
        fragmentsList.add(new MenuItem("Card view fragment", new CardsFragment()));
        fragmentsList.add(new MenuItem("Curved motion fragment", new CurvedMotionFragment()));
        fragmentsList.add(new MenuItem("Animate View State Changes", new AnimateViewStateChangesFragment()));
        fragmentsList.add(new MenuItem("Edit Text Transition", new EditTextTransitionFargment()));
        fragmentsList.add(new MenuItem("Collapsing toolbar", new CollapsingToolbarFragment()));
        fragmentsList.add(new MenuItem("Parallax fragment", new ParallaxFragment()));
        fragmentsList.add(new MenuItem("Search fragment", new BlurFragment()));
        fragmentsList.add(new MenuItem("Bound change fragment", new BoundChangeFragment()));
        fragmentsList.add(new MenuItem("Secondo livello", new BlurFragment()));
    }

    public List<MenuItem> getAllMenuItems() {
        return fragmentsList;
    }

    public List<MenuItem> SecondMenuFragments() {
        fragmentsList.clear();
        fragmentsList.add(new MenuItem("Second", new ButtonTextFragment()));
        fragmentsList.add(new MenuItem("Second", new ButtonTextFragment()));
        fragmentsList.add(new MenuItem("Second", new ButtonTextFragment()));
        fragmentsList.add(new MenuItem("Second", new ButtonTextFragment()));
        fragmentsList.add(new MenuItem("Second", new ButtonTextFragment()));
        fragmentsList.add(new MenuItem("Second", new ButtonTextFragment()));
        fragmentsList.add(new MenuItem("Second", new ButtonTextFragment()));
        fragmentsList.add(new MenuItem("Second", new ButtonTextFragment()));
        fragmentsList.add(new MenuItem("Second", new ButtonTextFragment()));
        return fragmentsList;
    }
    public List<MenuItem> mainMenuFragments() {
        fragmentsList.clear();
        fragmentsList.add(new MenuItem("Intro", new IntroFragment()));
        fragmentsList.add(new MenuItem("Text Transition", new ButtonTextFragment()));
        fragmentsList.add(new MenuItem("Circular animation", new CircularAnimationFragment()));
        fragmentsList.add(new MenuItem("Activity transition", new ActivityTransitionFragment()));
        fragmentsList.add(new MenuItem("Card view fragment", new CardsFragment()));
        fragmentsList.add(new MenuItem("Curved motion fragment", new CurvedMotionFragment()));
        fragmentsList.add(new MenuItem("Animate View State Changes", new AnimateViewStateChangesFragment()));
        fragmentsList.add(new MenuItem("Edit Text Transition", new EditTextTransitionFargment()));
        fragmentsList.add(new MenuItem("Collapsing toolbar", new CollapsingToolbarFragment()));
        fragmentsList.add(new MenuItem("Parallax fragment", new ParallaxFragment()));
        fragmentsList.add(new MenuItem("Blur fragment", new BlurFragment()));
        fragmentsList.add(new MenuItem("Bound change fragment", new BoundChangeFragment()));
        fragmentsList.add(new MenuItem("Secondo livello", new BlurFragment()));
        return fragmentsList;
    }
}
