package com.example.expenseapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class removeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    // Define the private variables here.
    private TextView field1;
    private Spinner removeSp;
    private dataBase removedataBase;
    private List<String> mylist1;
    private ArrayList<String> l1, l2, l3, l4, l5, l6;
    private Button b1;
    private int positionInt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        field1 = (TextView)findViewById(R.id.entryField);
        removeSp = (Spinner)findViewById(R.id.removeSpinner);
        removedataBase = new dataBase(getApplicationContext());
        b1 = (Button)findViewById(R.id.removeButton);

        // Get the data from the database.
        mylist1 = removedataBase.getData();

        if(mylist1.isEmpty())
        {
            Toast.makeText(this, "There are no entries in the database yet.", Toast.LENGTH_LONG).show();

            Intent myintent = new Intent(removeActivity.this, MainActivity.class);
            startActivity(myintent);
        }
        else
        {
            // If it has actual values in it.
            // If the database has values in it already.
            l1 = new ArrayList<>();
            l2 = new ArrayList<>();
            l3 = new ArrayList<>();
            l4 = new ArrayList<>();
            l5 = new ArrayList<>();
            l6 = new ArrayList<>();

            // Iterate through our list.
            for(int i = 0; i < mylist1.size(); i++)
            {
                if(i == 0 || i % 6 == 0)
                    l1.add("Entry #" + mylist1.get(i));
                else if(i == 1 || (i-1) % 6 == 0)
                    l2.add(mylist1.get(i));
                else if(i == 2 || (i-2) % 6 == 0)
                    l3.add(mylist1.get(i));
                else if(i == 3 || (i-3) % 6 == 0)
                    l4.add(mylist1.get(i));
                else if(i == 4 || (i-4) % 6 == 0)
                    l5.add(mylist1.get(i));
                else if (i == 5 || (i-5) % 6 == 0)
                    l6.add(mylist1.get(i));
            }

            // Add the spinner and update the spinner view.
            updateRemoveSpinner(l1);
            removeSp.setOnItemSelectedListener(this);
        }

        // Set a listener on the button.
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Create an alert dialog.
                AlertDialog.Builder builder = new AlertDialog.Builder(removeActivity.this);
                // If the user presses yes, then it will delete it. If no then it will return to the screen.
                builder.setTitle("Are you sure?");
                builder.setMessage("Are you sure you wish to delete this entry?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        // Call The delete function from the database.
                        removedataBase.removeData(positionInt);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        // Close the dialog box.
                        dialogInterface.cancel();
                    }
                });

                // Put this into action.
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
    {
        String temp = l1.get(position) + "\n"
                + "Name: " + l2.get(position) + "\n"
                + "Category: " + l3.get(position) + "\n"
                + "Date: " + l4.get(position) + "\n"
                + "Amount: " + l5.get(position) + "\n"
                + "Note: " + l6.get(position);
        positionInt = position;
        field1.setText(temp);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) { }

    public void updateRemoveSpinner(ArrayList<String> n)
    {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, n);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        removeSp.setAdapter(dataAdapter);
    }
}
