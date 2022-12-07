package com.project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.project.models.Voucher;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Voucher.db";
    private static int DATABASE_VERSION = 1;

    public SQLiteHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE vouchers("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "title TEXT,time TEXT,status TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public List<Voucher> getVoucherAll(){
        List<Voucher> list = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        String order = "time DESC";
        Cursor rs = st.query("vouchers",null,null,
                null,null,null,order);
        while (rs != null && rs.moveToNext()) {
            int id = rs.getInt(0);
            String title = rs.getString(1);
            String time = rs.getString(2);
            String status = rs.getString(3);
            list.add(new Voucher(id,title,time,status));
        }
        return list;
    }


    public long addVoucher (Voucher voucher) {
        ContentValues values = new ContentValues();
        values.put("title",voucher.getTitle());
        values.put("time",voucher.getTime());
        values.put("status",voucher.getStatus());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert("vouchers",null,values);
    }

    public int delete (int id) {
        String whereClause = "id= ?";
        String[] whereArgs = {Integer.toString(id)};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete("vouchers",whereClause,whereArgs);
    }
}
