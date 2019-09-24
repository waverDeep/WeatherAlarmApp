package com.example.weatheralarmapp.db_connect;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.weatheralarmapp.alarm.AlarmItem;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    //구지 쿼리문 자체를 static으로 사용하실 필요는 없습니당 메모리 낭비를 초래할 수 있어요
    //public static final String CREATE_TABLE = "create table alarm (id integer primary key, noon text, hour integer, minute integer, mon boolean, tue boolean, wed boolean, thu boolean, fri boolean, sat boolean, sun boolean, delay integer, weather text);";
    //public static final String DROP_TABLE =

    // 생성자
    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    // 데이터베이스 테이블 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String alarmSQL = "create table alarm (" +
                        "id integer primary key autoincrement, " +
                        "noon text, " +
                        "hour integer, " +
                        "minute integer, " +
                        "mon integer, " +
                        "tue integer, " +
                        "wed integer, " +
                        "thu integer, " +
                        "fri integer, " +
                        "sat integer, " +
                        "sun integer, " +
                        "delay integer, " +
                        "weather text);";

        final String diarySQL = "create table diary (" +
                "id integer primary key, " +
                "day text," +
                " memo_contents text);";

        db.execSQL(alarmSQL);
        db.execSQL(diarySQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String alarmSQL = "drop table if exists alarm";
        final String diarySQL = "drop table if exists diary";
        db.execSQL(alarmSQL);
        db.execSQL(diarySQL);
        onCreate(db);
    }

    // 현재 이 클래스는 SQLiteOpenHelper를 상속받고 있기 때문에 구지 SQLiteDatabase 를 매개변수로 주지 않으셔도됩니다.
    public void addContact( String noon, int hour, int minute,
                           int mon, int tue, int wed, int thu, int fri, int sat, int sun, int delay, String weather) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = String.format("insert into alarm values(null,'%s','%d','%d','%d','%d','%d','%d','%d','%d','%d','%d','%s');",
                                      noon, hour, minute, mon, tue, wed, thu, fri, sat, sun, delay, weather);
        db.execSQL(sql);

        db.close();
    }

    public ArrayList<AlarmItem> readContact() {
        SQLiteDatabase db = getReadableDatabase();

        String sql = "select * from alarm";
        Cursor cursor = db.rawQuery(sql, null);

        ArrayList<AlarmItem> items = new ArrayList<>();

        while(cursor.moveToNext()){
            AlarmItem alarmItem = new AlarmItem();
            alarmItem.setNoon(cursor.getString(1));
            alarmItem.setHour(cursor.getInt(2));
            alarmItem.setMinute(cursor.getInt(3));
            alarmItem.setMon(cursor.getInt(4));
            alarmItem.setTue(cursor.getInt(5));
            alarmItem.setWed(cursor.getInt(6));
            alarmItem.setThu(cursor.getInt(7));
            alarmItem.setFri(cursor.getInt(8));
            alarmItem.setSat(cursor.getInt(8));
            alarmItem.setSun(cursor.getInt(8));

            items.add(alarmItem);



        }

        db.close();
        return items;

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

//
//    public AlarmItem readAlarm(DBHelper dbHelper) {
//
//            SQLiteDatabase database = dbHelper.getReadableDatabase();
//
//            Cursor cursor = dbHelper.readContact();
///*
//        while (cursor.moveToNext()) {
//            item.setHour(Integer.parseInt(cursor.getString(2)));
//            item.setMinute(Integer.parseInt(cursor.getString(3)));
//
//            addItem(item);
//
//        }
//*/
//            for (int i = 0; i < cursor.getCount(); i++) {
//                cursor.moveToNext();
//                String id = cursor.getString(0);
//
//                if (id != null) {
//                    AlarmItem item1 = new AlarmItem(cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9), cursor.getInt(10) );
//                    Log.d("noon", item1.getNoon());
//                    Log.d("hour", String.valueOf(item1.getHour()));
//                    Log.d("minute", String.valueOf(item1.getMinute()));
//                    Log.d("mon", String.valueOf(item1.getbMon()));
//                    Log.d("tue", String.valueOf(item1.getbTue()));
//                    Log.d("wed", String.valueOf(item1.getbWed()));
//                    Log.d("thu", String.valueOf(item1.getbThu()));
//                    Log.d("fri", String.valueOf(item1.getbFri()));
//                    Log.d("sat", String.valueOf(item1.getbSat()));
//                    Log.d("sun", String.valueOf(item1.getbSun()));
//                    return item1;
//                }
//            }
//
//            cursor.close();
//            dbHelper.close();
//            return null;
//    }


}
