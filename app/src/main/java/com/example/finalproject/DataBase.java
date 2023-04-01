package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="database";
    private static final String TABLE1="table1";
    private static final String TABLE2="table2";
    public DataBase( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1="CREATE TABLE "+TABLE1+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, id TEXT)";
        String table2="CREATE TABLE "+TABLE2+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, id TEXT)";
        db.execSQL(table1);
        db.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
        onCreate(db);
    }
    public boolean addData(String name){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("name",name);
        values.put("id","صحيح مسلم");
        sqLiteDatabase.insert(TABLE1,null, values);
        return true;
    }
    public Cursor getDataID(){
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor data = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE1
                ,null);
        return data;
    }
}
