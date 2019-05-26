package com.example.evolution;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Bgm extends Service {

    private MediaPlayer mediaPlayer;

    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this,R.raw.bgm);
        if(!mediaPlayer.isPlaying()) {
            mediaPlayer.setVolume(0.5f,0.5f);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
    }
    public int onStartCommand(Intent intent, int flag, int startId) {
        super.onStartCommand(intent,flag,startId);
        if(!mediaPlayer.isPlaying()) {
            mediaPlayer.setVolume(0.5f,0.5f);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
        return START_STICKY;
    }
    public void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}