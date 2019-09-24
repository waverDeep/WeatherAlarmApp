package com.example.weatheralarmapp.db_connect;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MemoDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "diary.db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table diary (id integer primary key, day text, memo_contents text);";
    public static final String DROP_TABLE = "drop table if exists diary";

    public MemoDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addContact(String id, String day, String memo_contents, SQLiteDatabase database) {
        String sql = "insert into diary values('" + id + "', '" + day + "', '" + memo_contents + "');";
        database.execSQL(sql);
    }

    public Cursor readContact(SQLiteDatabase database) {
        String sql = "select id, day, memo_contents from diary";
        Cursor cursor1 = database.rawQuery(sql, null);
        return cursor1;
    }

    public void AllDelete(SQLiteDatabase database) {
        database.delete("diary", null, null);
    }

}