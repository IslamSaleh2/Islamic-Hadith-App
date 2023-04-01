package com.example.finalproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHalper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="DB";
    private static final String TABLE_NAME="table1";
    private static final String TABLE_NAME3="table3";
    private static final String TABLE_NAME2= "table2";
    private static final String TABLE_FAVOURITE="table_fav";

    public DBHalper(Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1="CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        String table2="CREATE TABLE "+TABLE_FAVOURITE+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        String table3="CREATE TABLE "+TABLE_NAME2+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        String table4="CREATE TABLE "+TABLE_NAME3+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        db.execSQL(table1);
        db.execSQL(table2);
        db.execSQL(table3);
        db.execSQL(table4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FAVOURITE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME3);
        onCreate(db);
    }

    public boolean addDataName(String name){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("name",name);
        sqLiteDatabase.insert(TABLE_NAME3,null, values);
        return true;
    }
    public boolean addData(String name) {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("name",name);
        sqLiteDatabase.insert(TABLE_NAME3,null, values);
        return true;
    }

    public Cursor getDataID(){
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor data = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME3
        ,null);
        return data;
    }
    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT FROM table2 WHERE name = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

}
