package com.example.angus.ea_project;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private ListView lv;
    Button toolBarBtn;
    boolean swap = false;
    List<Map<String, Object>> mList;

    String[ ] item1 ={"MingPao", "Oncc", "Yahoo","Ettoday","HK01","Headline","RTHK","Thinkhk","LTN"};
    int image1[] ={R.drawable.logo_mingpao, R.drawable.logo_oncc, R.drawable.logo_yahoo, R.drawable.logo_ettoday, R.drawable.logo_hk01, R.drawable.logo_headline, R.drawable.logo_rthk, R.drawable.logo_thinkhk, R.drawable.logo_ltn};
    String[ ] item2 ={"All","Business","Entertainment","Health","Science","Sports","Technology"};
    int image2[] ={R.drawable.logo_all,R.drawable.logo_business,R.drawable.logo_entertainment,R.drawable.logo_health,R.drawable.logo_science,R.drawable.logo_sports,R.drawable.logo_technology};

    public menu_CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu__category, container, false);
        lv= (ListView) view.findViewById(R.id.lv);

        callByPub();

        toolBarBtn = (Button)view.findViewById(R.id.toolbarbtn);
        toolBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation myAnimation1 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
                        R.anim.fade_out);
                if(swap) {

                    lv.setAdapter(null);
                    lv.startAnimation(myAnimation1);
                    callByPub();
                    swap = false;
                }
                else
                {
                    lv.setAdapter(null);
                    lv.startAnimation(myAnimation1);
                    callBytopic();
                    swap = true;
                }
            }
        });


        return view;
}
    private  void callByPub()
    {
        Animation myAnimation1 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
                R.anim.fade_in);

        mList = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < item1.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imgView", image1[i]); //data in key-value pair
            item.put("txtView", item1[i]);
            mList.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getApplicationContext(), mList, R.layout.list_item2,
                new String[] { "imgView", "txtView" },
                new int[] { R.id.imgView ,R.id.txtView });

        lv.setAdapter(adapter);
        lv.startAnimation(myAnimation1);
        lv.setOnItemClickListener(listViewOnItemClick1);
    }
    private void callBytopic()
    {   Animation myAnimation2 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
            R.anim.fade_in);

        mList = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < item2.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imgView", image2[i]); //data in key-value pair
            item.put("txtView", item2[i]);
            mList.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getApplicationContext(), mList, R.layout.list_item2,
                new String[] { "imgView", "txtView" },
                new int[] { R.id.imgView ,R.id.txtView });
        lv.setAdapter(adapter);
        lv.startAnimation(myAnimation2);
        lv.setOnItemClickListener(listViewOnItemClick2);

    }
    private ListView.OnItemClickListener listViewOnItemClick1 = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            Log.d("info1", Integer.toString(position));
            Intent it = new Intent(getActivity().getApplicationContext(), news_subtopic.class);
            Bundle bundle = new Bundle();
            bundle.putInt("page",1 );
            bundle.putInt("position",position );
            bundle.putString("title",item1[position]);
            it.putExtras(bundle);
            startActivity(it);


        }
    };
    private ListView.OnItemClickListener listViewOnItemClick2 = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            Log.d("info2", Integer.toString(position));
            Intent it = new Intent(getActivity().getApplicationContext(), news_subtopic.class);
            Bundle bundle = new Bundle();
            bundle.putInt("page",2 );
            bundle.putInt("position",position );
            bundle.putString("title",item2[position]);
            it.putExtras(bundle);
            startActivity(it);

        }
    };
}


