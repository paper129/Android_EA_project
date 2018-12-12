package com.example.angus.ea_project;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceActivity;

public class GlobalVariable extends Application {
    private int sharePlaying;
    private MediaPlayer playingnow;

    public void setsharePlaying(int sharePlaying){
        this.sharePlaying = sharePlaying;
    }

    public int getsharePlaying(){
        return sharePlaying;
    }
    public  void  setPlayingnow(MediaPlayer playingnow){
        this.playingnow=playingnow;
    }
    public  MediaPlayer getPlayingmow()
    {
        return playingnow;
    }


}
