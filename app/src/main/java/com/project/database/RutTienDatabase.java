package com.project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class RutTienDatabase extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "RutTien.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "ruttien";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_BANK = "nguontienrut";
    private static final String COLUMN_MONEY = "sotienrut";

    public RutTienDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_BANK + " TEXT, " +
                COLUMN_MONEY + " INTEGER);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

     public void addRutTienList(String nguontienrut, int sotienrut){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_BANK, nguontienrut);
        cv.put(COLUMN_MONEY, sotienrut);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1  ){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Withdraw successfully", Toast.LENGTH_SHORT).show();
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
