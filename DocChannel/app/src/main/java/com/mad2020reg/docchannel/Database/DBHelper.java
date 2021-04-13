package com.mad2020reg.docchannel.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.provider.BaseColumns;

/****Question 03 (a) ****/

import androidx.annotation.Nullable;
import androidx.room.Database;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DocChannel.db";
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String SQL_CREATE_ENTRIES =

                /****Question 03 (b)- (i) ****/
                "CREATE TABLE " + Patient.PatientDetails.TABLE_NAME + " (" +
                        Patient.PatientDetails._ID + " INTEGER PRIMARY KEY," +
                        Patient.PatientDetails.COLUMN_NAME_NAME + " TEXT," +
                        Patient.PatientDetails.COLUMN_NAME_AGE + " TEXT," +
                        Patient.PatientDetails.COLUMN_NAME_CONTACT + " TEXT)";


        db.execSQL(SQL_CREATE_ENTRIES);




        String SQL_CREATE_ENTRIES_1 =

                /****Question 03 (b)- (ii) ****/

                "CREATE TABLE " + Channeling.ChannelingDetails.TABLE_NAME + " (" +
                        Channeling.ChannelingDetails._ID + " INTEGER PRIMARY KEY," +
                        Channeling.ChannelingDetails.COLUMN_NAME_PATIENT_ID + " TEXT," +
                        Channeling.ChannelingDetails.COLUMN_NAME_DOC_CAT + " TEXT," +
                        Channeling.ChannelingDetails.COLUMN_NAME_DOCTOR + " TEXT," +
                        Channeling.ChannelingDetails.COLUMN_NAME_TOTAL + " TEXT)";


        db.execSQL(SQL_CREATE_ENTRIES);




        String SQL_CREATE_ENTRIES_2 =


                /****Question 03 (b)- (iii) ****/
                "CREATE TABLE " + LabTests.TestDetails.TABLE_NAME + " (" +
                        LabTests.TestDetails._ID + " INTEGER PRIMARY KEY," +
                        LabTests.TestDetails.COLUMN_NAME_TEST + " TEXT," +
                        LabTests.TestDetails.COLUMN_NAME_PRICE + " TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    /****Question 03 (c) ****/
    public long addPatient(String name , String age , String contact){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        // statements?
        values.put(Patient.PatientDetails.COLUMN_NAME_NAME, name);
        values.put(Patient.PatientDetails.COLUMN_NAME_AGE, age);
        values.put(Patient.PatientDetails.COLUMN_NAME_CONTACT, contact);

        long newRowId = db.insert(Patient.PatientDetails.TABLE_NAME, null, values);

        return newRowId;

    }

    /****Question 03 (d) ****/

    public long addChanneling(String pid ,String category ,String doctor ,String total){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();


        // statements?
        values.put(Channeling.ChannelingDetails.COLUMN_NAME_PATIENT_ID, pid);
        values.put(Channeling.ChannelingDetails.COLUMN_NAME_DOC_CAT, category);
        values.put(Channeling.ChannelingDetails.COLUMN_NAME_DOCTOR, doctor);
        values.put(Channeling.ChannelingDetails.COLUMN_NAME_TOTAL, total);

        long newRowId = db.insert(Channeling.ChannelingDetails.TABLE_NAME, null, values);

        return newRowId;


    }

    /****Question 03 (e) ****/
    public  long addTest(String test ,String price){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        // statements?
        values.put(LabTests.TestDetails.COLUMN_NAME_TEST, test);
        values.put(LabTests.TestDetails.COLUMN_NAME_PRICE, price);

        long newRowId = db.insert(Channeling.ChannelingDetails.TABLE_NAME, null, values);

        return newRowId;
    }

    public List getPatient(String contact){



        /****Question 03 (f) ****/
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                Patient.PatientDetails.COLUMN_NAME_NAME,
                Patient.PatientDetails.COLUMN_NAME_AGE,
                Patient.PatientDetails.COLUMN_NAME_CONTACT
        };

// Filter results WHERE "title" = 'My Title'
        String selection = Patient.PatientDetails.COLUMN_NAME_CONTACT + " LIKE ?";
        String[] selectionArgs = { contact };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                Patient.PatientDetails.COLUMN_NAME_CONTACT + " ASC";

        Cursor cursor = db.query(
                Patient.PatientDetails.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List Patient = new ArrayList<>();
        while(cursor.moveToNext()) {
            String name= cursor.getString(cursor.getColumnIndexOrThrow(Patient.PatientDetails.COLUMN_NAME_NAME));
            String age= cursor.getString(cursor.getColumnIndexOrThrow(Patient.PatientDetails.COLUMN_NAME_AGE));
            String con= cursor.getString(cursor.getColumnIndexOrThrow(Patient.PatientDetails.COLUMN_NAME_CONTACT));
            Patient.add(name);
            Patient.add(age);
            Patient.add(con);
        }
        cursor.close();
        return Patient;

    }




    public List getChannelingInfo(String pid ,String doctor , String category){



        /****Question 03 (g) ****/
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                Channeling.ChannelingDetails.COLUMN_NAME_PATIENT_ID,
                Channeling.ChannelingDetails.COLUMN_NAME_DOC_CAT,
                Channeling.ChannelingDetails.COLUMN_NAME_DOCTOR,
                Channeling.ChannelingDetails.COLUMN_NAME_TOTAL
        };

// Filter results WHERE "title" = 'My Title'
        String selection =  Channeling.ChannelingDetails.COLUMN_NAME_PATIENT_ID +  Channeling.ChannelingDetails.COLUMN_NAME_DOCTOR +  Channeling.ChannelingDetails.COLUMN_NAME_DOC_CAT + " LIKE ?";
        String[] selectionArgs = { pid , doctor , category };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                Channeling.ChannelingDetails.COLUMN_NAME_PATIENT_ID + " ASC";

        Cursor cursor = db.query(
                Channeling.ChannelingDetails.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List Channel = new ArrayList<>();
        while(cursor.moveToNext()) {
            String id= cursor.getString(cursor.getColumnIndexOrThrow(Channeling.ChannelingDetails.COLUMN_NAME_PATIENT_ID));
            String cat= cursor.getString(cursor.getColumnIndexOrThrow(Channeling.ChannelingDetails.COLUMN_NAME_DOC_CAT));
            String doc= cursor.getString(cursor.getColumnIndexOrThrow( Channeling.ChannelingDetails.COLUMN_NAME_DOCTOR));
            String amount= cursor.getString(cursor.getColumnIndexOrThrow(Channeling.ChannelingDetails.COLUMN_NAME_TOTAL));
            Channel.add(id);
            Channel.add(cat);
            Channel.add(doc);
            Channel.add(amount);
        }
        cursor.close();
        return Channel;

    }

    public List getTestInfo(String tests){


        /****Question 03 (h) ****/
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                LabTests.TestDetails.COLUMN_NAME_TEST,
                LabTests.TestDetails.COLUMN_NAME_PRICE
        };

// Filter results WHERE "title" = 'My Title'
        String selection =  LabTests.TestDetails.COLUMN_NAME_TEST + " LIKE ?";
        String[] selectionArgs = { tests };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                LabTests.TestDetails.COLUMN_NAME_TEST + " ASC";

        Cursor cursor = db.query(
                LabTests.TestDetails.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List userInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String test= cursor.getString(cursor.getColumnIndexOrThrow( LabTests.TestDetails.COLUMN_NAME_TEST));
            String price= cursor.getString(cursor.getColumnIndexOrThrow( LabTests.TestDetails.COLUMN_NAME_PRICE));
            userInfo.add(test);
            userInfo.add(price);
        }
        cursor.close();
        return userInfo;

    }

}
