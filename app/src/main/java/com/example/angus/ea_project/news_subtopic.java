package com.example.angus.ea_project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class news_subtopic extends AppCompatActivity {
    String topic;
    int position1;
    private ListView lv;
    private ProgressDialog pd;
    List<Map<String, Object>> mList;
    String[ ] item1 ={"All","Business","Entertainment","Health","Science","Sports","Technology"};
    int image[] ={R.drawable.logo_all,R.drawable.logo_business,R.drawable.logo_entertainment,R.drawable.logo_health,R.drawable.logo_science,R.drawable.logo_sports,R.drawable.logo_technology};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_subtopic);
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        topic= bundle.getString("topic");
        position1=bundle.getInt("position");
        getSupportActionBar().setTitle(topic);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        lv= (ListView)findViewById(R.id.lv);
        mList = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < item1.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imgView", image[i]); //data in key-value pair
            item.put("txtView", item1[i]);
            mList.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, mList, R.layout.list_item2,
                new String[] { "imgView", "txtView" },
                new int[] { R.id.imgView ,R.id.txtView });
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(listViewOnItemClick);

    }
    private ListView.OnItemClickListener listViewOnItemClick = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            pd = new ProgressDialog(news_subtopic.this);
            pd.setMessage("Loading..");
            pd.setTitle("Getting Data");
            pd.show();
            lv.setAdapter(null);
            String name="";
            switch (position1) {
                case 0:
                    name="Mingpao.com";
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;

            }
            pd.dismiss();
        }
    };
}
