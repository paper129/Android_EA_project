package com.example.angus.ea_project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class menu_CategoryFragment extends Fragment {
    View view;
    String[ ] list={"MingPao", "Oncc", "Yahoo","Ettoday","HK01","Headline","RTHK","Thinkhk","LTN"};

    public menu_CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu__category, container, false);

        return view;
}

}
