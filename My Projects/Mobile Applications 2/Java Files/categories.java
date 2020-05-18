package com.example.expenseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class categories extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    // Declare our private attributes.
    private Spinner catSpinner;
    private TextView catField;
    private Button catButton;
    private List<String> data;
    private ArrayList<String> a1, a2, a3, a4, a5, a6;
    private dataBase catdb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_layout);

        // Attach our widgets to the proper means here.
        catSpinner = (Spinner)findViewById(R.id.spinnerNum5);
        catField = (TextView)findViewById(R.id.categoryField);
        catField.setMovementMethod(new ScrollingMovementMethod());
        catButton = (Button)findViewById(R.id.categoryButton);
        catdb = new dataBase(getApplicationContext());

        // Gather the data already in here.
        data = catdb.getData();

        if(data.isEmpty())
        {
            Toast.makeText(this, "The database is empty.", Toast.LENGTH_LONG).show();
            // Make an intent to go back.
            Intent quick = new Intent(categories.this, MainActivity.class);
            startActivity(quick);
        }
        else
        {
            // If it has actual values in it.
            // If the database has values in it already.
            a1 = new ArrayList<>();
            a2 = new ArrayList<>();
            a3 = new ArrayList<>();
            a4 = new ArrayList<>();
            a5 = new ArrayList<>();
            a6 = new ArrayList<>();

            // Iterate through our list.
            for(int i = 0; i < data.size(); i++)
            {
                if(i == 0 || i % 6 == 0)
                    a1.add("Entry #" + data.get(i));
                else if(i == 1 || (i-1) % 6 == 0)
                    a2.add(data.get(i));
                else if(i == 2 || (i-2) % 6 == 0)
                    a3.add(data.get(i));
                else if(i == 3 || (i-3) % 6 == 0)
                    a4.add(data.get(i));
                else if(i == 4 || (i-4) % 6 == 0)
                    a5.add(data.get(i));
                else if (i == 5 || (i-5) % 6 == 0)
                    a6.add(data.get(i));
            }

            // Set the adapter.
            categoryAdapter(a3);
            // Put a listener on it.
            catSpinner.setOnItemSelectedListener(this);
        }

        // Make the cat button functional.
        catButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quick2 = new Intent(categories.this, MainActivity.class);
                startActivity(quick2);
            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
    {
        // Get the text.
        String strTemp = catSpinner.getSelectedItem().toString(), strTemp2 = "";
        // Gather the information from the database.
        List<String> tempList = catdb.getCategories(position, strTemp);
        ArrayList<String> t1, t2, t3, t4, t5, t6;
        t1 = new ArrayList<>();
        t2 = new ArrayList<>();
        t3 = new ArrayList<>();
        t4 = new ArrayList<>();
        t5 = new ArrayList<>();
        t6 = new ArrayList<>();


        // Set up this in our arrays.
        for(int i = 0; i < tempList.size(); i++)
        {
            if(i == 0 || i % 6 == 0)
                t1.add("Entry #" + tempList.get(i));
            else if(i == 1 || (i-1) % 6 == 0)
                t2.add(tempList.get(i));
            else if(i == 2 || (i-2) % 6 == 0)
                t3.add(tempList.get(i));
            else if(i == 3 || (i-3) % 6 == 0)
                t4.add(tempList.get(i));
            else if(i == 4 || (i-4) % 6 == 0)
                t5.add(tempList.get(i));
            else if (i == 5 || (i-5) % 6 == 0)
                t6.add(tempList.get(i));
        }

        // Then set this as the text field.
        for(int w = 0; w < t1.size(); w++)
        {
            strTemp2 += t1.get(w) + "\n"
                    + "Name: " + t2.get(w) + "\n"
                    + "Category: " + t3.get(w) + "\n"
                    + "Date: " + t4.get(w) + "\n"
                    + "Amount: " + t5.get(w) + "\n"
                    + "Note: " + t6.get(w) + "\n\n";
        }
        // Finally set the text.
        catField.setText(strTemp2);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) { }

    // Define the adapter function.
    public void categoryAdapter(ArrayList<String> n)
    {
        ArrayList<String> temp;
        boolean flag = false;
        ArrayList<Integer> marker = new ArrayList<>();

        // Create a linked hash set.
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(n);
        temp = new ArrayList<>(hashSet);
        /*
        for(int i = 0; i < n.size(); i++)
        {
            for(int q = i + 1; q < n.size(); q++)
            {
                if(n.get(i).equals(n.get(q)))
                {
                    flag = true;
                    // Set the marker for q.
                    marker.add(q);
                }
            }
            // Then fill the temp array.
            if(flag)
            {
                // Remove the duplicate.
                temp.add(n.get(i));
                for(int x = 0; x < marker.size(); x++)
                    n.remove(marker.get(x));

                // Set flag back to false.
                flag = false;
            }
            else
                temp.add(n.get(i));
        }
        */


        // Then finally add this to the adapter.
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        catSpinner.setAdapter(dataAdapter);
    }
}













