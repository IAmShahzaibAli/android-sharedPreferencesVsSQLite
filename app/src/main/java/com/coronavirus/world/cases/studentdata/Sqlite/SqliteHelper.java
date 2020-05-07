package com.coronavirus.world.cases.studentdata.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "data.db";
    private static final int VERSION = 1;
    private static final String NAME = "NAME";
    private static final String AGE = "AGE";
    private static final String TABLE_NAME = "data1";


    public SqliteHelper(@Nullable Context context )
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " +TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + "NAME TEXT," + "AGE INTEGER);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query2 = "DROP TABLE IF EXISTS data1;";
        db.execSQL(query2);
        onCreate(db);

    }
    public void insert(String name,int age,SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

    }






}
