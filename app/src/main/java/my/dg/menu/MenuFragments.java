package my.dg.menu;


import java.util.ArrayList;
import java.util.List;

import my.dg.fragments.ActivityTransitionFragment;
import my.dg.fragments.AlphaAnimationFragment;
import my.dg.fragments.AnimateViewStateChangesFragment;
import my.dg.fragments.AnimatedIconAdvancedFragment;
import my.dg.fragments.BlurFragment;
import my.dg.fragments.BoundChangeFragment;
import my.dg.fragments.ButtonTextFragment;
import my.dg.fragments.CardsFragment;
import my.dg.fragments.ChainSpringAnimationFragment;
import my.dg.fragments.CircularAnimationFragment;
import my.dg.fragments.CollapsingToolbarFragment;
import my.dg.fragments.CurvedMotionFragment;
import my.dg.fragments.DialogInputSnackBarFragment;
import my.dg.fragments.EditTextTransitionFargment;
import my.dg.fragments.IconAnimationFragment;
import my.dg.fragments.IconShapeMorphFragment;
import my.dg.fragments.IntroFragment;
import my.dg.fragments.ParallaxFragment;
import my.dg.fragments.SpringAnimationFragment;

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
        fragmentsList.add(new MenuItem("Blur effect", new BlurFragment()));
        fragmentsList.add(new MenuItem("Dialog snakbar", new DialogInputSnackBarFragment()));
        fragmentsList.add(new MenuItem("Alpha Animation", new AlphaAnimationFragment()));
        fragmentsList.add(new MenuItem("Icon Animation", new IconAnimationFragment()));
        fragmentsList.add(new MenuItem("Advanced animation icon loading", new AnimatedIconAdvancedFragment()));
        fragmentsList.add(new MenuItem("Spring animation", new SpringAnimationFragment()));
        fragmentsList.add(new MenuItem("Spring chain animation", new ChainSpringAnimationFragment()));
        fragmentsList.add(new MenuItem("Icon shape morph", new IconShapeMorphFragment()));
    }

    public List<MenuItem> getAllMenuItems() {
        return fragmentsList;
    }
}
