package com.project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseTable  extends SQLiteOpenHelper {


    private Context context;
    private static final String DATABASE_NAME = "TableList.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_table";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name_table";
    private static final String COLUMN_PHONE = "phone_table";
    private static final String COLUMN_NUMBER= "number_table";
    private static final String COLUMN_DATE= "date_table";
    private static final String COLUMN_TIME= "time_table";
    private static final String COLUMN_NOTE= "note_table";


    public DatabaseTable(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PHONE + " REAL, " +
                COLUMN_NUMBER + " REAL, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TIME + " TEXT, " +
                COLUMN_NOTE + " TEXT);";
        db.execSQL(query);

    }
    public void addTable(String name, Double phone, Double number, String date, String time, String note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_PHONE, phone);
        cv.put(COLUMN_NUMBER, number);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_TIME, time);
        cv.put(COLUMN_NOTE, note);
        long result = db.insert(TABLE_NAME,null, cv);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
