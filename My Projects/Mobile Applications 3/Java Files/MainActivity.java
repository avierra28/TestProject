package com.example.homework5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button b2, ab1, ab2, ab3;
    private ImageView myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ab1 = (Button)findViewById(R.id.oceanButton);
        ab2 = (Button)findViewById(R.id.mountainCreek);
        ab3 = (Button)findViewById(R.id.fireamb);
        myImage = (ImageView)findViewById(R.id.picture);
        b2 = (Button)findViewById(R.id.stop);
        ab1.setOnClickListener(this);
        ab2.setOnClickListener(this);
        ab3.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    // Set up our public void on click.
    public void onClick(View src)
    {
        // Have a switch to determine what to place.
        switch(src.getId())
        {
            case R.id.oceanButton:
            {
                // Start the class for the ocean sound only.
                startService(new Intent(MainActivity.this, oceanSound.class));
                Drawable draw = getResources().getDrawable(R.drawable.ocean_picture);
                myImage.setImageDrawable(draw);
                break;
            }
            case R.id.mountainCreek:
            {
                // Start the class for the ocean sound only.
                startService(new Intent(MainActivity.this, mountain.class));
                Drawable draw = getResources().getDrawable(R.drawable.creek);
                myImage.setImageDrawable(draw);
                break;
            }
            case R.id.fireamb:
            {
                // Start the class for the ocean sound only.
                startService(new Intent(MainActivity.this, fireAmbience.class));
                Drawable draw = getResources().getDrawable(R.drawable.fire);
                myImage.setImageDrawable(draw);
                break;
            }
            case R.id.stop:
            {
                // If the user wants to stop any of the services at any time.
                stopService(new Intent(MainActivity.this, mountain.class));
                stopService(new Intent(MainActivity.this, oceanSound.class));
                stopService(new Intent(MainActivity.this, fireAmbience.class));

            }
        }

    }
}
