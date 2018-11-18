package com.example.angus.ea_project;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class menu_FollowingFragment extends Fragment {
    private Button btn1;
    private FirebaseAuth firebaseAuth;

    public menu_FollowingFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu__following, container, false);
        btn1 = (Button)view.findViewById(R.id.toolbarbtn);
        btn1.setOnClickListener(btn1_Lis);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null) {
        }
        else
        {
            Fragment frag2;
            frag2 = new menu_LoginFragment();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, frag2); // replace a Fragment with Frame Layout
            ((MainActivity) getActivity()).getSupportActionBar().setTitle("Login");
            transaction.commit();
        }
        return view;
    }
    private View.OnClickListener btn1_Lis =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           startActivity(new Intent(getActivity(),Add_Following_Activity.class));
        }
    };

}
