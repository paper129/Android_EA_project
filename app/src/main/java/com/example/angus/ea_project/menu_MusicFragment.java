package com.example.angus.ea_project;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.net.URL;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;



/**
 * A simple {@link Fragment} subclass.
 */
public class menu_MusicFragment extends Fragment {


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        MediaPlayer mediaPlayer = new MediaPlayer();
        String url = "http://rthk.hk/live2.m3u";
        Uri path = Uri.parse(url);

        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(String.valueOf(path));
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.prepareAsync();
        } catch (Exception e){

        }

    }


}
