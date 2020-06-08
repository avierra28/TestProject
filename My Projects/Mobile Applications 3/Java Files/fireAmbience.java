package com.example.homework5;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class fireAmbience extends Service
{
    MediaPlayer mp3;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate()
    {

        mp3 = MediaPlayer.create(this, R.raw.fire);
        mp3.setLooping(true);
    }
    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Crackling fire ambience started", Toast.LENGTH_LONG).show();
        mp3.start();
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        mp3.stop();
    }
}
