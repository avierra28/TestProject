package com.example.expenseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class dataBase extends SQLiteOpenHelper
{
    // Define the database, table name and columns.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Money Tracker";
    private static final String TABLE_NAME1 = "records";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME1 = "name";
    private static final String COLUMN_NAME2 = "category";
    private static final String COLUMN_NAME3 = "date";
    private static final String COLUMN_NAME4 = "amount";
    private static final String COLUMN_NAME5 = "note";

    // Now define the constructor to build this database.
    public dataBase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // The creation of the table in the oncreate method.
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the string to insert into the db.
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + "\n" +
                "(\n" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                COLUMN_NAME1 + " TEXT\tNOT NULL,\n" +
                COLUMN_NAME2 + " TEXT\tNOT NULL,\n" +
                COLUMN_NAME3 + " TEXT\tNOT NULL,\n" +
                COLUMN_NAME4 + " INT\tNOT NULL,\n" +
                COLUMN_NAME5 + " TEXT\tDEFAULT NULL\n" +
                ");";
        db.execSQL(createTable);
    }

    // The onupgrade method.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    // Create a helper method to insert into the database.
    public void insertInto(String e1, String e2, String e3, double e4, String e5)
    {
        // Get our writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Put these values into the database.
        values.put(COLUMN_NAME1, e1);
        values.put(COLUMN_NAME2, e2);
        values.put(COLUMN_NAME3, e3);
        values.put(COLUMN_NAME4, e4);
        values.put(COLUMN_NAME5, e5);

        // Write them to the database.
        db.insert(TABLE_NAME1, null, values);
        db.close();
    }

    // Define the update data functrion.
    public void updateData(String c1, String c2, String c3, double c4, String c5, int global)
    {
        // Begin.
        String updateQuery = "UPDATE " + TABLE_NAME1 + "\n"
                + "SET " + COLUMN_NAME1 + " = '" + c1 + "',\n"
                + COLUMN_NAME2 + " = '" + c2 + "',\n"
                + COLUMN_NAME3 + " = '" + c3 + "',\n"
                + COLUMN_NAME4 + " = " + c4 + ",\n"
                + COLUMN_NAME5 + " = '" + c5 + "'\n"
                + "WHERE " + COLUMN_ID + " = " + global;
        SQLiteDatabase tempdb = this.getReadableDatabase();

        tempdb.execSQL(updateQuery);
        tempdb.close();
    }

    public void removeData(int n)
    {
        // Set the query for this.
        n++;
        String removeQuery = "DELETE FROM " + TABLE_NAME1 + "\n"
                + "WHERE " + COLUMN_ID + " = " + n;
        SQLiteDatabase tempdb = this.getReadableDatabase();
        tempdb.execSQL(removeQuery);
        tempdb.close();
    }

    public List<String> getCategories(int position, String cat)
    {
        // Begin by getting our categories.
        List<String> catString = new ArrayList<>();

        // Create the query.
        String catQuery = "SELECT * FROM " + TABLE_NAME1 + "\n"
                + "WHERE " + COLUMN_NAME2 + " = '" + cat + "'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(catQuery, null);

        if(cursor.moveToFirst())
        {
            do {
                catString.add(cursor.getString(0));
                catString.add(cursor.getString(1));
                catString.add(cursor.getString(2));
                catString.add(cursor.getString(3));
                catString.add(cursor.getString(4));
                catString.add(cursor.getString(5));
            } while (cursor.moveToNext());
        }

        // Then close the cursor.
        cursor.close();
        db.close();
        return catString;
    }

    // Define the get data function.
    public List<String> getData()
    {
        // Start the definition.
        List<String> myArray = new ArrayList<>();

        // Create the query.
        String myQuery = "SELECT * FROM " + TABLE_NAME1;
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
                    myArray.add(cursor.getString(0));
                    myArray.add(cursor.getString(1));
                    myArray.add(cursor.getString(2));
                    myArray.add(cursor.getString(3));
                    myArray.add(cursor.getString(4));
                    myArray.add(cursor.getString(5));

                } while (cursor.moveToNext());
            }

            // Close the database and cursor.
            cursor.close();
            db.close();
            return myArray;
        }
        catch(Exception e)
        {
            String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + "\n" +
                    "(\n" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    COLUMN_NAME1 + " TEXT\tNOT NULL,\n" +
                    COLUMN_NAME2 + " TEXT\tNOT NULL,\n" +
                    COLUMN_NAME3 + " TEXT\tNOT NULL,\n" +
                    COLUMN_NAME4 + " INT\tNOT NULL,\n" +
                    COLUMN_NAME5 + " TEXT\tDEFAULT NULL\n" +
                    ");";
            // Insert this in.
            db.execSQL(createTable);
        }
        db.close();
        return myArray;
    }
}
