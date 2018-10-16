package com.example.angus.ea_project;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by Angus on 16/10/2018.
 */

public class CustomListAdapter extends ArrayAdapter<List_Item>{

    ArrayList<List_Item> Item;
    Context context;
    int resource;
    public CustomListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<List_Item> Item) {
        super(context, resource, Item);
        this.Item = Item;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getApplicationContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item1,null,true);
        }

        List_Item item = getItem(position); // Object
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgView);
        if(item.getImage()=="null")
        {
            Log.d("IMAGe","NO");
            imageView.setImageResource(R.drawable.no_image);
            imageView.getLayoutParams().height = 310;
            imageView.getLayoutParams().width = 450;
        }
        else {
            Picasso.with(getContext().getApplicationContext()).load(item.getImage()).resize(450, 300).into(imageView);
        }
        Log.d("------------>",item.getImage());
        TextView textView = (TextView) convertView.findViewById(R.id.txtView);
        textView.setText(item.getTitle());
        return convertView;
    }

}
