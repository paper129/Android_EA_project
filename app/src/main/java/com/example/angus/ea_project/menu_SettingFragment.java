package com.example.angus.ea_project;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class menu_SettingFragment extends Fragment {

    private TextView tx_all[] = new TextView[3];
    private int tx_id[] ={R.id.txFontSize,R.id.txFontStyle,R.id.txTheme};
    private Spinner sp1;
    private String font_size[]={"14","16","18","22","24","26"};
    public menu_SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu__setting, container, false);
        SharedPreferences SystemInfo = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        String data = SystemInfo.getString("font_size", "22");
        Log.d("System Info",data);
        for (int i=0;i<tx_all.length;i++)
        {
            tx_all[i] =(TextView) view.findViewById(tx_id[i]);
            tx_all[i].setTextSize(Integer.parseInt(data));
        }

        sp1 = (Spinner) view.findViewById(R.id.fontSize);
        ArrayAdapter<String> sizeAd = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, font_size);
        sizeAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(sizeAd);
        for(int i=0;i<font_size.length;i++)
        {
            if(font_size[i].equals(data))
            {
                sp1.setSelection(i,true);
                break;
            }
        }
        sp1.setOnItemSelectedListener(sp1_Lis);
        return view;
    }
    private AdapterView.OnItemSelectedListener sp1_Lis = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SharedPreferences SystemInfo = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
            int value = sp1.getSelectedItemPosition();
            SystemInfo.edit().putString("font_size",font_size[value]).commit();
            changeTextSize(font_size[value]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    private void changeTextSize(String size){
        for (int i=0;i<tx_all.length;i++)
        {
            tx_all[i].setTextSize(Integer.parseInt(size));
        }
    }


}
