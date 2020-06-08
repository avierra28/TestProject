package com.example.homework5;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class oceanSound extends Service
{
    MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate()
    {

        mp = MediaPlayer.create(this, R.raw.ocean);
        mp.setLooping(true);
    }
    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Ocean Sounds starting now", Toast.LENGTH_LONG).show();
        mp.start();
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        mp.stop();
    }
}
