package com.example.angus.ea_project;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.os.AsyncTaskCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;








/**
 * A simple {@link Fragment} subclass.
 */
public class menu_HotNewsFragment extends Fragment {
    ListView lv;
    public menu_HotNewsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu__hot_news, container, false);
        lv=(ListView)view.findViewById(R.id.lv);

        return view;
    }
    class MyTask extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }


    }

}
