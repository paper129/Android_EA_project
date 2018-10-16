package com.example.angus.ea_project;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class menu_HotNewsFragment extends Fragment {
    private ListView lv;

    private ImageView imageView;
    ArrayList<List_Item> arrayList;
    List<Map<String, Object>> mList;

    public menu_HotNewsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu__hot_news, container, false);
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        arrayList = new ArrayList<>();
        lv = (ListView) view.findViewById(R.id.lv);

        String url = "https://newsapi.org/v2/top-headlines?country=hk&apiKey=307781e9e6ca4234a05abe536b55252d";

        StringRequest strReq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

                    public void onResponse(String response) {
                        try {
                            int TOTAL;
                            //get from data to JSON_OBJECT
                            JSONObject JSON_oj = new JSONObject(response);
                            String STATUS = JSON_oj.getString("status");
                            TOTAL = JSON_oj.getInt("totalResults");
                            //get from data to JSON_ARRAY
                            JSONArray articles_array = JSON_oj.getJSONArray("articles");
                            String name[]=new String[TOTAL],author[]=new String[TOTAL],title[]=new String[TOTAL],description[]=new String[TOTAL],img_url[]=new String[TOTAL],time[]=new String[TOTAL];


                            for (int i = 0; i < TOTAL; i++) {
                                JSONObject articles_oj = articles_array.getJSONObject(i);

                                JSONObject Source_oj = articles_oj.getJSONObject("source");
                                arrayList.add(new List_Item(
                                        articles_oj.getString("urlToImage"),
                                        articles_oj.getString("title")
                                ));

                                name[i] = Source_oj.getString("name");
                                author[i] = articles_oj.getString("author");

                                description[i] = articles_oj.getString("description");

                                time[i] = articles_oj.getString("publishedAt");

                                Log.d("------------>", "fetching");


                            }

                        } catch (JSONException e) {
                            Log.d("------------>","ERROR1");
                            e.printStackTrace();

                        }
                        CustomListAdapter adapter = new CustomListAdapter(
                                getActivity().getApplicationContext(),R.layout.list_item1,arrayList
                        );
                        lv.setAdapter(adapter);
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(getActivity().getApplicationContext(), news_detail.class);
                                startActivity(intent); // start Intent
                            }
                        });


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                error.printStackTrace();
            }
        });
        queue.add(strReq);



        return view;
    }


    }


