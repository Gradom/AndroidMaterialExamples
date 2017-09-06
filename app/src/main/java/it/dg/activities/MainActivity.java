package it.dg.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import it.dg.R;
import it.dg.fragments.IntroFragment;
import it.dg.menu.MenuAdapter;
import it.dg.menu.MenuFragments;
import it.dg.menu.RecyclerViewListener;


public class MainActivity extends AppCompatActivity implements RecyclerViewListener {

    private RecyclerView menuListItem;
    private Fragment fragment;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        xmlReferences();
        setupToolbar();
        setupDrawer();
        initializeMenu();
        loadFragment();
    }

    private void loadFragment() {
        FragmentTransaction transaction;
        if (fragmentManager == null) {
            fragmentManager = getFragmentManager();
        }
        if (fragment == null) {
            fragment = new IntroFragment();
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragment_container, fragment);
        } else {
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
        }
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case R.id.action_search:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    private void setupDrawer() {
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                LayoutAnimationController  animation = AnimationUtils.loadLayoutAnimation(MainActivity.this, R.anim.recyclerview_layout_animation);
                menuListItem.setLayoutAnimation(animation);
                adapter.updateList(MenuFragments.getInstance().mainMenuFragments());
            }
        };
        drawerLayout.addDrawerListener(toggle);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    MenuAdapter adapter;

    private void initializeMenu() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        menuListItem.setLayoutManager(mLayoutManager);

        adapter = new MenuAdapter(MenuFragments.getInstance().getAllMenuItems(), this);
        LayoutAnimationController  animation = AnimationUtils.loadLayoutAnimation(this, R.anim.recyclerview_layout_animation);
        menuListItem.setLayoutAnimation(animation);
        menuListItem.setAdapter(adapter);
    }

    private void xmlReferences() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuListItem = (RecyclerView) findViewById(R.id.menu_item_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(null);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public void itemSelected(View view, it.dg.menu.MenuItem item, int position) {
        drawerLayout.closeDrawers();
        if (item.getLabel().equals("Secondo livello")) {
            LayoutAnimationController  animation = AnimationUtils.loadLayoutAnimation(this, R.anim.recyclerview_layout_animation);
            menuListItem.setLayoutAnimation(animation);
            adapter.updateList(MenuFragments.getInstance().SecondMenuFragments());
            drawerLayout.openDrawer(Gravity.START);
            return;
        }
        if (item != null) {
            fragment = item.getFragment();
        }
        loadFragment();
    }
}