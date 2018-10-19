package com.example.angus.ea_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class news_detail extends AppCompatActivity {
    String title,description,time,image_url;
    ImageView img_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

       Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        title = bundle.getString("title");
        description =bundle.getString("description");
        time = bundle.getString("publishedAt");
        image_url = bundle.getString("urlToImage");
        getSupportActionBar().setTitle(title);
        Log.d("detail", title);
        img_view = (ImageView) findViewById(R.id.imageView);
        if(image_url == "null")
        {
            img_view.setImageResource(R.drawable.no_image);
            img_view.getLayoutParams().height = 310;
            img_view.getLayoutParams().width = 450;
        }
        else
        {
            Picasso.with(this).load(image_url).resize(1000, 700).into(img_view);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }


}
