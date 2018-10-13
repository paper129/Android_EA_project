package com.example.angus.ea_project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class menu_LoginFragment extends Fragment {

    //TextView tx1,tx2,tx3;
    public menu_LoginFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //tx1=(TextView) getView().findViewById(R.id.tx1);
        //tx2=(TextView) getView().findViewById(R.id.tx2);
        //tx3=(TextView) getView().findViewById(R.id.tx3);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu__login, container, false);
    }

}
