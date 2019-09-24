package com.example.weatheralarmapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.weatheralarmapp.DB.AlarmDBHelper;

import java.util.ArrayList;



class AlarmAdapter extends BaseAdapter {
    ArrayList<AlarmItem> alarms = new ArrayList<AlarmItem>();
    Context context;


    @Override
    public int getCount() {
        return alarms.size();
    }

    @Override
    public Object getItem(int position) {
        return alarms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        context = parent.getContext();
/*
        AlarmView view = new AlarmView(context);
        AlarmItem item = alarms.get(pos);

        view.setHour(item.getHour());
        view.setMinute(item.getMinute());
        view.setNoon(item.getNoon());
        view.setIvMon(item.getMon());
        view.setIvTue(item.getTue());
        view.setIvWed(item.getWed());
        view.setIvThu(item.getThu());
        view.setIvFri(item.getFri());
        view.setIvSat(item.getSat());
        view.setIvSun(item.getSun());
*/


        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.alarm_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView noonTextView = (TextView) convertView.findViewById(R.id.tvNoon) ;
        TextView hourTextView = (TextView) convertView.findViewById(R.id.tvHour) ;
        TextView minuteTextView = (TextView) convertView.findViewById(R.id.tvMinute) ;
        ImageView monImageView = (ImageView) convertView.findViewById(R.id.ivMon);
        ImageView tueImageView = (ImageView) convertView.findViewById(R.id.ivTue);
        ImageView wedImageView = (ImageView) convertView.findViewById(R.id.ivWed);
        ImageView thuImageView = (ImageView) convertView.findViewById(R.id.ivThu);
        ImageView friImageView = (ImageView) convertView.findViewById(R.id.ivFri);
        ImageView satImageView = (ImageView) convertView.findViewById(R.id.ivSat);
        ImageView sunImageView = (ImageView) convertView.findViewById(R.id.ivSun);
        final ToggleButton toggleButton = (ToggleButton) convertView.findViewById(R.id.toggleButton);
        final ToggleButton tbAlarmDeleteCheck = (ToggleButton) convertView.findViewById(R.id.tbAlarmDeleteCheck);
        ImageView ivAlarmEdit = (ImageView) convertView.findViewById(R.id.ivAlarmEdit);



/*
        // Data Set(AlarmItem)에서 position에 위치한 데이터 참조 획득
        AlarmItem alarmitem = alarms.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        monImageView.setImageDrawable(alarmitem.getMon());
        tueImageView.setImageDrawable(alarmitem.getTue());
        wedImageView.setImageDrawable(alarmitem.getWed());
        thuImageView.setImageDrawable(alarmitem.getThu());
        friImageView.setImageDrawable(alarmitem.getFri());
        satImageView.setImageDrawable(alarmitem.getSat());
        sunImageView.setImageDrawable(alarmitem.getSun());
        noonTextView.setText(alarmitem.getNoon());
//        hourTextView.setText(alarmitem.getHour());
 //       minuteTextView.setText(alarmitem.getMinute());
*/

/*
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = toggleButton.isChecked();
                if(state == true)
                {
                    toggleButton.setChecked(false);
                }
                else if(state == false)
                {
                    toggleButton.setChecked(true);
                }
            }
        });

        tbAlarmDeleteCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = tbAlarmDeleteCheck.isChecked();
                if(state == true)
                {
                    tbAlarmDeleteCheck.setChecked(false);
                }
                else if(state == false)
                {
                    tbAlarmDeleteCheck.setChecked(true);
                }
            }
        });
*/
        ivAlarmEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, AlarmAddActivity.class);
                context.startActivity(intent);

            }
        });

        return convertView;
    }



    public void onClick(int position, AlarmItem item) {
        alarms.set(position, item);
    }

    public void addItem(AlarmItem item){

        AlarmItem items = new AlarmItem();


        if(item.getbMon() != 0){items.ivMon.setImageResource(R.drawable.mon);}
        if(item.getbTue() != 0){items.ivTue.setImageResource(R.drawable.tue);}
        if(item.getbWed() != 0){items.ivWed.setImageResource(R.drawable.wed);}
        if(item.getbThu() != 0){items.ivThu.setImageResource(R.drawable.thu);}
        if(item.getbFri() != 0){items.ivFri.setImageResource(R.drawable.fri);}
        if(item.getbSat() != 0){items.ivSat.setImageResource(R.drawable.sat);}
        if(item.getbSun() != 0){items.ivSun.setImageResource(R.drawable.sun);}

        items.setHour(item.hour);
        items.setMinute(item.minute);
        items.setNoon(item.noon);
        items.setIvAlarmEdit(item.ivAlarmEdit);
        items.setTbAlarmDeleteCheck(item.tbAlarmDeleteCheck);
        items.setToggleButton(item.toggleButton);

        alarms.add(items);
    }

}