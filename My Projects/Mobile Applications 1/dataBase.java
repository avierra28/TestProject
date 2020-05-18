package com.example.flashcards;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class dataBase extends SQLiteOpenHelper
{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Flashcards";
    private static final String TABLE_NAME = "cards";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME_QUESTION = "question";
    private static final String COLUMN_NAME_ANSWER = "answer";

    // Create a constructor.
    public dataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the string to insert into the db.

        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME_QUESTION + " TEXT,"
                + COLUMN_NAME_ANSWER + " TEXT)";
        // Insert this in.
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cards");
        onCreate(db);
    }

    // Create a helper function to insert whatever the user enters into the database.
    public void insertIntoTable(String q, String a) {
        // With q being the question and a being the answer.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Now write to the table anything the user inputs.
        values.put(COLUMN_NAME_QUESTION, q);
        values.put(COLUMN_NAME_ANSWER, a);

        // After this write it to the database.
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Creating a helper function to retrieve the data from the database.
    public List<String> getData()
    {
        // Create a list inside of a list.
        List<String> answer = new ArrayList<String>();

        // Create the query.
        String myQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();


        // Then set up our cursor.
        try
        {
            Cursor cursor = db.rawQuery(myQuery, null);
            // Now loop through.
            if(cursor.moveToFirst())
            {
                do {
                    // Add the second and third column to my list respectively.
                    answer.add(cursor.getString(1));
                    answer.add(cursor.getString(2));

                } while (cursor.moveToNext());
            }

            // Close the database and cursor.
            cursor.close();
            db.close();
            return answer;
        }
        catch(Exception e)
        {
            String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME_QUESTION + " TEXT,"
                    + COLUMN_NAME_ANSWER + " TEXT)";
            // Insert this in.
            db.execSQL(createTable);
        }

        db.close();

        // Then finally return the answer.
        return answer;
    }
}
