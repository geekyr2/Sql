package com.example.pc.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sql extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "contacts";


    public Sql(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INT,EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void insertData(String name, int number, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("MOBILE_NUMBER", number);
        contentValues.put("EMAIL", email);
        db.insert(TABLE_NAME, null, contentValues);
    }


    public Cursor search(int num) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE MOBILE_NUMBER = '" + num + "'";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public void update(String name, String number, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("EMAIL", email);
        db.update(TABLE_NAME, contentValues, "MOBILE_NUMBER = '" + number + "'", null);
    }

    public void delete(int num) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "MOBILE_NUMBER = '" + num + "'", null);

    }

}
