package com.project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BankDatabaseHelper extends SQLiteOpenHelper {

    //Phần này của Nguyên
    private Context context;
    private static final String DATABASE_NAME = "BANKLIST.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_banklist";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_BANKNAME = "bankname";
    private static final String COLUMN_BANKNUMBER = "banknumber";
    private static final String COLUMN_BANKHOLDER = "bankholder";
    private static final String COLUMN_BANKHOLDERID = "bankholderid";


    public BankDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_BANKNAME + " TEXT, " +
                COLUMN_BANKNUMBER + " INTEGER, " +
                COLUMN_BANKHOLDER + " TEXT, " +
                COLUMN_BANKHOLDERID + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void addBankList(String bankname, int banknumber, String bankholder, int bankholderid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_BANKNAME, bankname);
        cv.put(COLUMN_BANKNUMBER, banknumber);
        cv.put(COLUMN_BANKHOLDER, bankholder);
        cv.put(COLUMN_BANKHOLDERID, bankholderid);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
        }

    }
    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
