package com.example.homework5;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class mountain extends Service
{
    MediaPlayer mp2;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate()
    {

        mp2 = MediaPlayer.create(this, R.raw.mountain_creek);
        mp2.setLooping(true);
    }
    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Mountain Creek ambience starting", Toast.LENGTH_LONG).show();
        mp2.start();
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        mp2.stop();
    }
}
