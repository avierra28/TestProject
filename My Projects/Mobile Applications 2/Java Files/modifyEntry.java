package com.example.expenseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class modifyEntry extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private EditText nField, cField, dField, aField, n2Field;
    private Spinner anotherSpinner;
    private Button fin;
    private dataBase db2;
    private List<String> modifyList;
    private ArrayList<String> list1, list2, list3, list4, list5, primaryKey;
    private int globalPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_entry);

        // Set our components to their respective id's.
        assignFields();
        db2 = new dataBase(getApplicationContext());

        // Now check and see if its empty.
        modifyList = db2.getData();

        if(modifyList.isEmpty())
        {
            // Fill it with a default value.
            db2.insertInto("Steve Smith", "Finance", "July 2015", 12367.87, "No Note");

            // Call the spinner set up function.
            spinnerSetUp2();
        }
        else
        {
            // If the database has values in it already.
            list1 = new ArrayList<>();
            list2 = new ArrayList<>();
            list3 = new ArrayList<>();
            list4 = new ArrayList<>();
            list5 = new ArrayList<>();
            primaryKey = new ArrayList<>();

            // Iterate through our list.
            for(int i = 0; i < modifyList.size(); i++)
            {
                if(i == 0 || i % 6 == 0)
                    primaryKey.add("Entry #" + modifyList.get(i));
                else if(i == 1 || (i-1) % 6 == 0)
                    list1.add(modifyList.get(i));
                else if(i == 2 || (i-2) % 6 == 0)
                    list2.add(modifyList.get(i));
                else if(i == 3 || (i-3) % 6 == 0)
                    list3.add(modifyList.get(i));
                else if(i == 4 || (i-4) % 6 == 0)
                    list4.add(modifyList.get(i));
                else if (i == 5 || (i-5) % 6 == 0)
                    list5.add(modifyList.get(i));
            }

            // Update spinner.
            updateSpinner2(primaryKey);
            anotherSpinner.setOnItemSelectedListener(this);
        }

        // Create an onclick listener for our button.
        fin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Create some variables here.
                String s1, s2, s3, s5;
                double d1;
                ArrayList<String> holderList = new ArrayList<>();
                holderList = primaryKey;

                // Get the newly updated text fields.
                s1 = nField.getText().toString();
                s2 = cField.getText().toString();
                s3 = dField.getText().toString();
                d1 = Double.parseDouble(aField.getText().toString());
                s5 = n2Field.getText().toString();

                int quickTemp = anotherSpinner.getSelectedItemPosition();

                // Call a function in the database class to update this entry.
                db2.updateData(s1, s2, s3, d1, s5, Integer.parseInt(holderList.get(quickTemp).replaceAll("[^0-9]", "")));

                Intent goback2 = new Intent(modifyEntry.this, MainActivity.class);
                startActivity(goback2);
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
    {
        nField.setText(list1.get(position));
        cField.setText(list2.get(position));
        dField.setText(list3.get(position));
        aField.setText(list4.get(position));
        n2Field.setText(list5.get(position));
        globalPosition = position;
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) { }



    // Definition of the assignFields method.
    public void assignFields()
    {
        anotherSpinner = (Spinner)findViewById(R.id.modifySpinner);
        nField = (EditText)findViewById(R.id.name2);
        cField = (EditText)findViewById(R.id.category2);
        dField = (EditText)findViewById(R.id.date2);
        aField = (EditText)findViewById(R.id.amount2);
        n2Field = (EditText)findViewById(R.id.note2);
        fin = (Button)findViewById(R.id.finalizeEdit);
    }

    public void spinnerSetUp2()
    {
        List<String> temp1 = new ArrayList<>(), temp2 = new ArrayList<>();
        temp1.add("Entry #1");
        // Set up the adapter.
        anotherSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, temp1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        anotherSpinner.setAdapter(dataAdapter);

        // Now that its been inserted get the data.
        temp2 = db2.getData();

        // Change the fields.
        nField.setText(temp2.get(1));
        cField.setText(temp2.get(2));
        dField.setText(temp2.get(3));
        aField.setText(temp2.get(4));
        n2Field.setText(temp2.get(5));
    }

    public void updateSpinner2(List<String> temp)
    {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temp);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        anotherSpinner.setAdapter(dataAdapter);
    }
}
