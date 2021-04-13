package com.elzian.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {


    public DBHandler(Context context) {
        super(context, "Demo", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "CREATE TABLE user (username varchar(100), password varchar(100))";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String addRecord(String u, String p){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("username", u);
        cv.put("password", p);

        long res = db.insert("user",null, cv);

        if(res == -1){
            return "failed try again.";
        } else {
            return "successfully added.";
        }
    }

    public String read() {
        SQLiteDatabase db = this.getReadableDatabase();

        db.execSQL("SELECT * from user");
        return db.toString();

    }
}
