package com.project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String DBNAME = "login.db";
    public Database(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create Table users (phone TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop Table if exists users");
    }

    public Boolean insertData(Double phone, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("phone",phone );
        values.put("password", password);

        long result = db.insert("users", null, values);
        if(result == -1 )
            return false;
        else
            return  true;
    }

    public Boolean checkphone (Double phone){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where phone = ?", new String[] {String.valueOf(phone)});

        if(cursor.getCount() > 0 )
            return true;
        else
            return  false;
    }

    public Boolean checkpassword (Double phone, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where phone = ? and password = ?",  new String[] {String.valueOf(phone), password});

        if(cursor.getCount() > 0 )
            return true;
        else
            return  false;
    }

    public Boolean updatepassword (String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put ("password", password);
        long result = db.insert("users", null, values);
        if(result == -1 )
            return false;
        else
            return  true;
    }
}
