package com.example.angus.ea_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class news_detail extends AppCompatActivity {
    String title,description,time,image_url;
    ImageView img_view;
    TextView textView_description;
    TextView textView_title;
    TextView textView_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

       Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        img_view = (ImageView) findViewById(R.id.imageView);
        textView_description = (TextView)  findViewById(R.id.description);
        textView_title = (TextView) findViewById(R.id.title) ;
        textView_time = (TextView) findViewById(R.id.time);
        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        title = bundle.getString("title");
        description ="      "+bundle.getString("description");
        time = bundle.getString("publishedAt");
        image_url = bundle.getString("urlToImage");
        getSupportActionBar().setTitle("News");

        Log.d("------------>img",image_url);
        if(image_url == "NO_IMG" || image_url.equals(null))
        {
            Picasso.with(this).load(R.drawable.no_image).resize(1000, 700).into(img_view);
        }
        else
        {
            Picasso.with(this).load(image_url).resize(1000, 700).into(img_view);
        }
        textView_description.setText(description);
        textView_title.setText(title);
        textView_time.setText(time);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }


}
