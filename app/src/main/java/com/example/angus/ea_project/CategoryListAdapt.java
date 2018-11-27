package com.example.angus.ea_project;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Angus on 22/11/2018.
 */

public class CategoryListAdapt extends ArrayAdapter<List_Item> {
    private ArrayList<List_Item> Item;
    private Context context;
    private int resource;
    private String tx_size;
    private int page;
    int image1[] ={R.drawable.logo_mingpao, R.drawable.logo_oncc, R.drawable.logo_yahoo, R.drawable.logo_ettoday, R.drawable.logo_hk01, R.drawable.logo_headline, R.drawable.logo_rthk, R.drawable.logo_thinkhk, R.drawable.logo_ltn};
    int image2[] ={R.drawable.logo_all,R.drawable.logo_business,R.drawable.logo_entertainment,R.drawable.logo_health,R.drawable.logo_science,R.drawable.logo_sports,R.drawable.logo_technology};
    public CategoryListAdapt(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<List_Item> Item, String tx_size,int page) {
        super(context, resource, Item);
        this.Item = Item;
        this.context = context;
        this.resource = resource;
        this.tx_size = tx_size;
        this.page = page;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getApplicationContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item3, null, true);
        }
        if (page == 1) {
            List_Item item = getItem(position); // Object
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imgView3);
            imageView.setImageResource(image1[position]);
            TextView textView = (TextView) convertView.findViewById(R.id.txtView3);
            textView.setText(item.getTitle());
            textView.setTextSize(Integer.parseInt(tx_size));

        }
        if (page == 2) {
            List_Item item = getItem(position); // Object
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imgView3);
            imageView.setImageResource(image2[position]);
            TextView textView = (TextView) convertView.findViewById(R.id.txtView3);
            textView.setText(item.getTitle());
            textView.setTextSize(Integer.parseInt(tx_size));
        }
        return convertView;
    }
}
