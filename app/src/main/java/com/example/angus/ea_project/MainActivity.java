package com.example.angus.ea_project;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.LogWriter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNavigationDrawer();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setTitle("Hot News");
    }

    private void setNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        final Fragment fragment = null;
        Class fragmentClass;


        navView.setNavigationItemSelectedListener(new
             NavigationView.OnNavigationItemSelectedListener() {

                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    Fragment frag = null;
                    int positionId = menuItem.getItemId();

                if (positionId == R.id.Hot_News) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Hot News");
                    frag = new menu_HotNewsFragment();
                    Log.d("----------logd","1");

                } else if (positionId == R.id.Category) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Category");
                    frag = new menu_CategoryFragment();
                    Log.d("----------logd","2");


                } else if (positionId == R.id.News_Map) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("News Map");
                    frag = new menu_NewsMapFragment();
                    Log.d("----------logd","3");


                } else if (positionId == R.id.Music) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Music");
                    frag = new menu_MusicFragment();
                    Log.d("----------logd","4");


                } else if (positionId == R.id.Setting) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Setting");
                    frag = new menu_SettingFragment();
                    Log.d("----------logd","5");

                }
                else if (positionId == R.id.Login) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Setting");
                    frag = new menu_LoginFragment();
                    Log.d("----------logd","6");

                }

                    if (frag != null) {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame, frag); // replace a Fragment with Frame Layout
                        transaction.commit(); // commit the changes
                        drawerLayout.closeDrawers(); // close the all open Drawer Views
                        Log.d("----------logd","Passed");
                        return true;
                    }
                    else {
                        Log.d("----------logd", "Nothing");
                        return false;
                    }


            }
        });


    }
}
