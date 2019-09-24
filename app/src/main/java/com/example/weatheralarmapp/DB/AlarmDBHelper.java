package com.example.weatheralarmapp.DB;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.weatheralarmapp.AlarmItem;

public class AlarmDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "alarm.db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table alarm (id integer primary key, noon text, hour integer, minute integer, mon boolean, tue boolean, wed boolean, thu boolean, fri boolean, sat boolean, sun boolean, delay integer, weather text);";
    public static final String DROP_TABLE = "drop table if exists alarm";

    public AlarmDBHelper(Context context) {
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

    public void addContact(String id, String noon, int hour, int minute, boolean mon, boolean tue, boolean wed, boolean thu, boolean fri, boolean sat, boolean sun, int delay, String weather, SQLiteDatabase database) {
        String sql = "insert into alarm values('" + id + "', '" + noon + "', '" + hour + "', '" + minute + "', '"+ mon + "', '"+ tue + "', '"+ wed + "', '"+ thu + "', '"+ fri + "', '"+ sat + "', '"+ sun + "', '" + delay + "', '" + weather + "');";
        database.execSQL(sql);
    }

    public Cursor readContact(SQLiteDatabase database) {
        String sql = "select id from alarm";
        Cursor cursor1 = database.rawQuery(sql, null);
        return cursor1;
    }

    public void AllDelete(SQLiteDatabase database) {
        database.delete("alarm", null, null);
    }

    public Cursor getAllColumns(SQLiteDatabase database) {
        return database.query("alarm", null, null, null, null, null, null);
    }

    //ID 컬럼 얻어오기
    public Cursor getColumn(long id, SQLiteDatabase database) {
        Cursor c = database.query("alarm", null,
                "_id="+id, null, null, null, null);
        //받아온 컬럼이 null이 아니고 0번째가 아닐경우 제일 처음으로 보냄
        if (c != null && c.getCount() != 0)
            c.moveToFirst();
        return c;
    }


    public AlarmItem readAlarm(AlarmDBHelper dbHelper) {

            SQLiteDatabase database = dbHelper.getReadableDatabase();

            Cursor cursor = dbHelper.readContact(database);
/*
        while (cursor.moveToNext()) {
            item.setHour(Integer.parseInt(cursor.getString(2)));
            item.setMinute(Integer.parseInt(cursor.getString(3)));

            addItem(item);

        }
*/
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                String id = cursor.getString(0);

                if (id != null) {
                    AlarmItem item1 = new AlarmItem(cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10) );
                    Log.d("noon", item1.getNoon());
                    Log.d("hour", String.valueOf(item1.getHour()));
                    Log.d("minute", String.valueOf(item1.getMinute()));
                    Log.d("mon", String.valueOf(item1.getbMon()));
                    Log.d("tue", String.valueOf(item1.getbTue()));
                    Log.d("wed", String.valueOf(item1.getbWed()));
                    Log.d("thu", String.valueOf(item1.getbThu()));
                    Log.d("fri", String.valueOf(item1.getbFri()));
                    Log.d("sat", String.valueOf(item1.getbSat()));
                    Log.d("sun", String.valueOf(item1.getbSun()));
                    return item1;
                }
            }

            cursor.close();
            dbHelper.close();
            return null;
    }


}
