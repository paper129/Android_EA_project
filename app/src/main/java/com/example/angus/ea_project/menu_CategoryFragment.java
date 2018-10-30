package com.example.angus.ea_project;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class menu_CategoryFragment extends Fragment {
    View view;
    View view1;
    private ListView lv;
    Button toolBarBtn;
    boolean swap = true;
    List<Map<String, Object>> mList;

    String[ ] item1 ={"MingPao", "Oncc", "Yahoo","Ettoday","HK01","Headline","RTHK","Thinkhk","LTN"};
    int image[] ={R.drawable.logo_mingpao, R.drawable.logo_oncc, R.drawable.logo_yahoo, R.drawable.logo_ettoday, R.drawable.logo_hk01, R.drawable.logo_headline, R.drawable.logo_rthk, R.drawable.logo_thinkhk, R.drawable.logo_ltn};
    public menu_CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view1 = inflater.inflate(R.layout.activity_main, container, false);


        view = inflater.inflate(R.layout.fragment_menu__category, container, false);
        lv= (ListView) view.findViewById(R.id.lv);
        mList = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < item1.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imgView", image[i]); //data in key-value pair
            item.put("txtView", item1[i]);
            mList.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getApplicationContext(), mList, R.layout.list_item2,
                new String[] { "imgView", "txtView" },
                new int[] { R.id.imgView ,R.id.txtView });
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(listViewOnItemClick);
        return view;
}
    private ListView.OnItemClickListener listViewOnItemClick = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            Log.d("info",Integer.toString(position));
            Intent intent = new Intent(getActivity().getApplicationContext(), news_subtopic.class);
            Bundle bundle = new Bundle();
            bundle.putString("topic", item1[position]);
            bundle.putInt("position",position);
            intent.putExtras(bundle);
            startActivity(intent);

        }
    };
}


