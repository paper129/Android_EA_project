package com.example.angus.ea_project;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.os.AsyncTaskCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

import java.net.URLEncoder;


/**
 * A simple {@link Fragment} subclass.
 */
public class menu_HotNewsFragment extends Fragment {
    ListView lv;

    public menu_HotNewsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu__hot_news, container, false);
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());


        String url = "https://newsapi.org/v2/top-headlines?country=hk&apiKey=307781e9e6ca4234a05abe536b55252d";

        StringRequest strReq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

                    public void onResponse(String response) {
                        try {
                            //get from data to JSON_OBJECT
                            JSONObject JSON_oj = new JSONObject(response);
                            String STATUS = JSON_oj.getString("status");
                            int TOTAL = JSON_oj.getInt("totalResults");
                            //get from data to JSON_ARRAY
                            JSONArray articles_array = JSON_oj.getJSONArray("articles");
                            for (int i = 0; i < TOTAL; i++) {
                                JSONObject articles_oj = articles_array.getJSONObject(i);
                                JSONObject Source_oj = articles_oj.getJSONObject("source");
                                String name = Source_oj.getString("name");
                                String author = articles_oj.getString("author");
                                String title = articles_oj.getString("title");
                                String description = articles_oj.getString("description");
                                String img_url = articles_oj.getString("urlToImage");
                                String time = articles_oj.getString("publishedAt");

                                Log.d("------------>", title);


                            }
                        } catch (JSONException e) {
                            Log.d("------------>","ERROR1");
                            e.printStackTrace();

                        }
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
