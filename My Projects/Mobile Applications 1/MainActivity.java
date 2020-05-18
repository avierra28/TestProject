package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    /*
    Create our variables for the view components here.
     */
    private EditText front;
    private EditText back;
    private Spinner spin;
    private TextView answer;

    // Creating a private string array of front card answers.
    private ArrayList<String> fr;
    private ArrayList<String> bc;
    private dataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set our variables inside this on create method.
        front = (EditText)findViewById(R.id.front_card);
        back = (EditText)findViewById(R.id.back_card);
        spin = (Spinner)findViewById(R.id.my_spinner);
        answer = (TextView)findViewById(R.id.answer_text);
        answer.setText("4");
        db = new dataBase(getApplicationContext());

        // First load from the database
        List<String> li = db.getData();

        if(li.isEmpty())
        {
            setupArrayList();
            // Set up our spinner for functionality.
            setupSpinner();
        }
        else
        {
            fr = new ArrayList<String>();
            bc = new ArrayList<String>();

            // Set up a for loop.
            for(int i = 0; i < li.size(); i++)
            {
                if(i == 0 || i % 2 == 0)
                    fr.add(li.get(i));
                else
                    bc.add(li.get(i));
            }

            updateSpinner(fr);

            // Make sure the listener is on the spinner.
            spin.setOnItemSelectedListener(this);

        }

    }

    public void add_card(View view)
    {
        // onClick method for when the user adds a card to the deck.
        // Capture the front card and then the answer card.
        String frontCard = front.getText().toString();
        String backCard = back.getText().toString();

        // Check to see if anything has been entered.
        if(frontCard.isEmpty() || backCard.isEmpty())
        {
            // Present a toast
            Toast.makeText(MainActivity.this, "One or both field(s) are empty.", Toast.LENGTH_LONG).show();

            // Return back.
            return;
        }

        // Add these to the arrayLists.
        fr.add(frontCard);
        bc.add(backCard);
        // Update spinner visually.
        updateSpinner();

        // Now update this in the database.
        db.insertIntoTable(frontCard, backCard);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id)
    {
        // The position is the array index of what the user selects.
        answer.setText(bc.get(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) { }


    // Helper method to set up our array list.
    public void setupArrayList()
    {
        fr = new ArrayList<String>();
        bc = new ArrayList<String>();

        // Begin with the front carts.
        fr.add("What is a cell?");
        fr.add("What is a cytoskeleton?");
        fr.add("What is the mitochondria?");

        // Now add the back card corresponding answers.
        bc.add("Cells are the basic building blocks of all living things. The human body is composed of trillions of cells.");
        bc.add("The cytoskeleton is a network of long fibers that make up the cell’s structural framework.");
        bc.add("Mitochondria are complex organelles that convert energy from food into a form that the cell can use.");

        // Fill our database with our pre-loaded questions.
        filldataBase();
    }

    // Fill the database.
    public void filldataBase()
    {
        // Now call the insert into table.
        for(int i = 0; i < fr.size(); i++)
        {
            db.insertIntoTable(fr.get(i), bc.get(i));
        }
    }


    // Helper method to set up our spinner.
    public void setupSpinner()
    {
        spin.setOnItemSelectedListener(this);
        // Set up an arrayadapter.
        ArrayAdapter<ArrayList<String>> aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, fr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    // Another helper method to update spinner.
    public void updateSpinner()
    {
        ArrayAdapter<ArrayList<String>> aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, fr);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }
    public void updateSpinner(ArrayList<String> list1)
    {
        ArrayAdapter<ArrayList<String>> aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list1);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }
}
