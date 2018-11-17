package com.example.angus.ea_project;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class menu_LoginFragment extends Fragment {
    private Button btn_register, btn_Login;
    private  FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_menu__login, container, false);
        btn_register = (Button) view.findViewById(R.id.btn_register);
        btn_Login = (Button) view.findViewById(R.id.btnLogin);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getActivity());
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null)
        {
            Toast.makeText(getActivity(),"Error DataBase",Toast.LENGTH_SHORT).show();
        }

        btn_register.setOnClickListener(register_Lis);
        btn_Login.setOnClickListener(login_Lis);
        return view;
    }
    private View.OnClickListener login_Lis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //validate();
        }
    };
    private View.OnClickListener register_Lis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getActivity(),RegistrationActivity.class));
        }
    };
    private void validate(String userName,String userPassword){
        firebaseAuth.createUserWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getActivity(),"Login Successful",Toast.LENGTH_SHORT).show();
                    Fragment frag2 = null;
                    frag2 = new menu_HotNewsFragment();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag2); // replace a Fragment with Frame Layout
                    transaction.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
