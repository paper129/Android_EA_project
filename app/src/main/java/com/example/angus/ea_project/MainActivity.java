package com.example.angus.ea_project;

import android.app.FragmentManager;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Fragment frag1;


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
        frag1 = new menu_HotNewsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, frag1); // replace a Fragment with Frame Layout
        transaction.commit();

        getSupportActionBar().setTitle("Hot News");
    }
    /*
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate();
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.swap) {
            Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
    private void setNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        final Fragment fragment = null;
        Class fragmentClass;


        navView.setNavigationItemSelectedListener(new
             NavigationView.OnNavigationItemSelectedListener() {

                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    int positionId=0;
                    Fragment frag2 = null;
                    positionId = menuItem.getItemId();

                if (positionId == R.id.Hot_News) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Hot News");
                    frag2 = new menu_HotNewsFragment();
                    Log.d("----------logd","1");

                } else if (positionId == R.id.Category) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Category");
                    frag2 = new menu_CategoryFragment();
                    Log.d("----------logd","2");


                } else if (positionId == R.id.Following) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Following");
                    frag2 = new menu_FollowingFragment();
                    Log.d("----------logd","3");


                }else if (positionId == R.id.News_Map) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("News Map");
                    frag2 = new menu_NewsMapFragment();
                    Log.d("----------logd","4");


                } else if (positionId == R.id.Music) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Live radio");
                    frag2 = new menu_MusicFragment();
                    Log.d("----------logd","5");


                } else if (positionId == R.id.Setting) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Setting");
                    frag2 = new menu_SettingFragment();
                    Log.d("----------logd","6");

                }
                else if (positionId == R.id.Login) {

                    drawerLayout.closeDrawers();
                    getSupportActionBar().setTitle("Setting");
                    frag2 = new menu_LoginFragment();
                    Log.d("----------logd","7");

                }

                    if (frag2 != null) {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame, frag2); // replace a Fragment with Frame Layout
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
