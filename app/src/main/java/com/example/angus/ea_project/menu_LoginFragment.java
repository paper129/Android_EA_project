package com.example.angus.ea_project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class menu_LoginFragment extends Fragment {

   EditText et_Userid,et_Userpw;
    View view;
    public menu_LoginFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu__login, container, false);
        et_Userid = (EditText) view.findViewById(R.id.et_Userid);
        et_Userpw = (EditText) view.findViewById(R.id.et_Userpw);


        // Inflate the layout for this fragment
        return view;
    }

}
