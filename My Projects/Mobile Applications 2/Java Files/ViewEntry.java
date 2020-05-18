package com.example.expenseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ViewEntry extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private Spinner mySpin;
    private TextView nameField, categoryField, dateField, amountField, noteField;
    private ArrayList<String> myList1, myList2, myList3, myList4, myList5, idList;
    private dataBase db;
    private Button goBack;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewentry);

        // Set our components to their respective id's.
        mySpin = (Spinner)findViewById(R.id.mySpinner);
        nameField = (TextView) findViewById(R.id.name);
        categoryField = (TextView)findViewById(R.id.category);
        dateField = (TextView)findViewById(R.id.date);
        amountField = (TextView)findViewById(R.id.amount);
        noteField = (TextView)findViewById(R.id.note);
        goBack = (Button)findViewById(R.id.back);
        db = new dataBase(getApplicationContext());

        // Gather the data.
        List<String> li = db.getData();

        // If its empty, fill it with 1 default value.
        if(li.isEmpty()) {
            db.insertInto("Steve Smith", "Finance", "July 2015", 12367.87, "No Note");

            // Call the spinner set up function.
            spinnerSetUp();
        }
        else
        {
            // Else, if its not empty.
            myList1 = new ArrayList<>();
            myList2 = new ArrayList<>();
            myList3 = new ArrayList<>();
            myList4 = new ArrayList<>();
            myList5 = new ArrayList<>();
            idList = new ArrayList<>();

            // Iterate through our list.
            for(int i = 0; i < li.size(); i++)
            {
                if(i == 0 || i % 6 == 0)
                    idList.add("Entry #" + li.get(i));
                else if(i == 1 || (i-1) % 6 == 0)
                    myList1.add(li.get(i));
                else if(i == 2 || (i-2) % 6 == 0)
                    myList2.add(li.get(i));
                else if(i == 3 || (i-3) % 6 == 0)
                    myList3.add(li.get(i));
                else if(i == 4 || (i-4) % 6 == 0)
                    myList4.add(li.get(i));
                else if (i == 5 || (i-5) % 6 == 0)
                    myList5.add(li.get(i));
            }
            /*
            Now what we have.
            idList contains the autoincremented primary Id's.
            list1 contains the names.
            list2 contains the categories.
            list3 contains the dates.
            list4 contains the amounts.
            list5 contains the notes.
             */
            updateSpinner(idList);
            mySpin.setOnItemSelectedListener(this);
        }

        // Add a listener on the goback button.
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(ViewEntry.this, MainActivity.class);
                startActivity(backIntent);
            }
        });
    }

    public void spinnerSetUp()
    {
        List<String> temp1 = new ArrayList<>(), temp2 = new ArrayList<>();
        temp1.add("Entry #1");
        // Set up the adapter.
        mySpin.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, temp1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin.setAdapter(dataAdapter);

        // Set the view as well.
        temp2 = db.getData();
        nameField.setText(temp2.get(1));
        categoryField.setText(temp2.get(2));
        dateField.setText(temp2.get(3));
        amountField.setText(temp2.get(4));
        noteField.setText(temp2.get(5));
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
    {
        // The position is the array index of what the user selects.
        nameField.setText(myList1.get(position));
        categoryField.setText(myList2.get(position));
        dateField.setText(myList3.get(position));
        amountField.setText(myList4.get(position));
        noteField.setText(myList5.get(position));

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) { }

    // Definition of the update spinner function.
    public void updateSpinner(ArrayList<String> temp)
    {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin.setAdapter(dataAdapter);
    }

}
