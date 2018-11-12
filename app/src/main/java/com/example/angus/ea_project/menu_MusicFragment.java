package com.example.angus.ea_project;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class menu_MusicFragment extends Fragment {

    Button play,stop;
    MediaPlayer mediaPlayer;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu__music, container, false);
        play = (Button) view.findViewById(R.id.play);
        stop = (Button) view.findViewById(R.id.stop);
        mediaPlayer = new MediaPlayer();
        play.setOnClickListener(playListener);
        stop.setOnClickListener(stopListener);
        return view;
    }
    private View.OnClickListener playListener = new View.OnClickListener() {
        final String uri = "http://stm.rthk.hk/radio2";
        Uri path = Uri.parse(uri);
        @Override
        public void onClick(View v) {
            try{
                mediaPlayer.reset();
                mediaPlayer.setDataSource(getActivity().getApplicationContext(), path);
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer.start();
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };
    private View.OnClickListener stopListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediaPlayer.pause();
            mediaPlayer.reset();
        }
    };
}
