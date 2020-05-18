package com.example.expenseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CreateEntry extends AppCompatActivity
{
    // Define the variables we need to use up here.
    private EditText name1, category1, date1, amount1, note1;
    private ArrayList<String> arrList;
    private dataBase db;
    private Button finalizeButton;


    // Do the oncreate method.
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option1);

        // Link everything to their respective fields.
        name1 = (EditText)findViewById(R.id.name);
        category1 = (EditText)findViewById(R.id.category);
        date1 = (EditText)findViewById(R.id.date);
        amount1 = (EditText)findViewById(R.id.amount);
        note1 = (EditText)findViewById(R.id.note);
        db = new dataBase(getApplicationContext());

        // Create an onclick listener for the button.
        finalizeButton = (Button)findViewById(R.id.finalize);
        finalizeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                // Gather the text that was inputted in the screen.
                String n1 = name1.getText().toString(), c1 = category1.getText().toString(),
                        d1 = date1.getText().toString(), no1 = note1.getText().toString(),
                        aTest = amount1.getText().toString();

                double a1 = Double.parseDouble(amount1.getText().toString());

                // Make sure we have all the fields save the note to actually have text.
                if(n1.isEmpty() || c1.isEmpty() || d1.isEmpty() || aTest.isEmpty())
                {
                    // Warn with a toast.
                    Toast.makeText(CreateEntry.this, "One of the mandatory fields are empty", Toast.LENGTH_LONG).show();

                    // And return from the whole function.
                    return;
                }
                else
                    db.insertInto(n1, c1, d1, a1, no1);

                // Display a toast message.
                Toast.makeText(CreateEntry.this, "Entry Created. Going back to the Main Menu.", Toast.LENGTH_LONG).show();
                // Start an intent to go back to the main menu.
                Intent myIntent = new Intent(CreateEntry.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
