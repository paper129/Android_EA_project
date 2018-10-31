package com.example.angus.ea_project;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class menu_MusicFragment extends Fragment {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = "http://rthk.hk/live2.m3u";
        Uri path = Uri.parse(url);




        /*setContentView(R.layout.activity_main_vv);//***************
        myVideoView = (VideoView)this.findViewById(R.id.myVideoView);
        MediaController mc;
        mc = new MediaController(this);
        myVideoView.setMediaController(mc);
        urlStream = "http://rthk.hk/live2.m3u";
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                myVideoView.setVideoURI(Uri.parse(urlStream)); */
            }
}
