package com.example.angus.ea_project;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.bitmap;


public class menu_CategoryFragment extends Fragment {
    View view;
    private ListView lv;
    Button toolBarBtn;
    boolean swap = false;
    private ArrayList<List_Item> arrayList;

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


        /* for (int i = 0; image1.length < i; i++){

            public Bitmap getResizedBitmap(Bitmap image1[], int bitmapWidth, int bitmapHeight) {
                return Bitmap.createScaledBitmap(image1[], bitmapWidth, bitmapHeight,
                        true);
        } */

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

        arrayList = new ArrayList<>();
        for (int i = 0; i < item1.length; i++) {
            arrayList.add(new List_Item(item1[i],item1[i]));
        }
        SharedPreferences SystemInfo = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        String data1 = SystemInfo.getString("font_size", "22");
        String data2 = SystemInfo.getString("font_Style","font1");
        CategoryListAdapt adapter1 = new CategoryListAdapt(getActivity().getApplicationContext(),R.layout.list_item2,arrayList,data1,data2,1);
        lv.setAdapter(adapter1);
        lv.startAnimation(myAnimation1);
        lv.setOnItemClickListener(listViewOnItemClick1);
    }
    private void callBytopic()
    {   Animation myAnimation2 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
            R.anim.fade_in);

        arrayList = new ArrayList<>();
        for (int i = 0; i < item2.length; i++) {
            arrayList.add(new List_Item(item2[i],item2[i]));
        }
        SharedPreferences SystemInfo = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        String data1 = SystemInfo.getString("font_size", "22");
        String data2 = SystemInfo.getString("font_Style","font1");
        CategoryListAdapt adapter2 = new CategoryListAdapt(getActivity().getApplicationContext(),R.layout.list_item2,arrayList,data1,data2,2);
        lv.setAdapter(adapter2);
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
