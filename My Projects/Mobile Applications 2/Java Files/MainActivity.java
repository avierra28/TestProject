package com.example.expenseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    // Button variables.
    private Button firstButton, secondButton, thirdButton, fourthButton, fifthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the first button.
        firstButton = (Button)findViewById(R.id.createEntry);
        // Add the listener.
        firstButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Create an intent.
                Intent myIntent1 = new Intent(MainActivity.this, CreateEntry.class);
                startActivity(myIntent1);
            }
        });

        // Get the second button.
        secondButton = (Button)findViewById(R.id.viewEntry);
        // Add the listener.
        secondButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Create a second intent.
                Intent myIntent2 = new Intent(MainActivity.this, ViewEntry.class);
                startActivity(myIntent2);
            }
        });

        // Get the third button.
        thirdButton = (Button)findViewById(R.id.modify);
        // Add the listener.
        thirdButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Create a third intent.
                Intent myIntent3 = new Intent(MainActivity.this, modifyEntry.class);
                startActivity(myIntent3);
            }
        });

        // Get the fourth button.
        fourthButton = (Button)findViewById(R.id.delete);
        // Add the listener.
        fourthButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Launch the fourth activity.
                Intent myIntent4 = new Intent(MainActivity.this, removeActivity.class);
                startActivity(myIntent4);
            }
        });

        // Get the fifth button.
        fifthButton = (Button)findViewById(R.id.categories);
        // Add the listener.
        fifthButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Start an intent.
                Intent myIntent5 = new Intent(MainActivity.this, categories.class);
                startActivity(myIntent5);
            }
        });
    }
}
