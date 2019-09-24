package com.example.weatheralarmapp.alarm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.weatheralarmapp.R;

import java.util.ArrayList;



public class AlarmAdapter extends BaseAdapter {
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
        context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item_alarm, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView tvNoon = convertView.findViewById(R.id.tvNoon);
        TextView tvHour = convertView.findViewById(R.id.tvHour);
        TextView tvMinute = convertView.findViewById(R.id.tvMinute);
        ImageView ivMon = convertView.findViewById(R.id.ivMon);
        ImageView ivTue = convertView.findViewById(R.id.ivTue);
        ImageView ivWed = convertView.findViewById(R.id.ivWed);
        ImageView ivThu = convertView.findViewById(R.id.ivThu);
        ImageView ivFri = convertView.findViewById(R.id.ivFri);
        ImageView ivSat = convertView.findViewById(R.id.ivSat);
        ImageView ivSun = convertView.findViewById(R.id.ivSun);
        ToggleButton toggleButton = convertView.findViewById(R.id.toggleButton);
        ToggleButton tbAlarmDeleteCheck = convertView.findViewById(R.id.tbAlarmDeleteCheck);
        ImageView ivAlarmEdit = convertView.findViewById(R.id.ivAlarmEdit);

        AlarmItem alarmItem = alarms.get(position);

        // 데이터 세팅
        tvNoon.setText(alarmItem.getNoon());
        tvHour.setText(alarmItem.getHour()+"");
        tvMinute.setText(alarmItem.getMinute()+"");
        ivMon.setImageResource(alarmItem.getMon());
        ivTue.setImageResource(alarmItem.getTue());
        ivWed.setImageResource(alarmItem.getWed());
        ivThu.setImageResource(alarmItem.getThu());
        ivFri.setImageResource(alarmItem.getFri());
        ivSat.setImageResource(alarmItem.getSat());
        ivSun.setImageResource(alarmItem.getSun());





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

        AlarmItem temp = new AlarmItem();


        if(item.getbMon() != 0){temp.setMon(R.drawable.mon);}
        if(item.getbTue() != 0){temp.setTue(R.drawable.tue);}
        if(item.getbWed() != 0){temp.setWed(R.drawable.wed);}
        if(item.getbThu() != 0){temp.setbThu(R.drawable.thu);}
        if(item.getbFri() != 0){temp.setFri(R.drawable.fri);}
        if(item.getbSat() != 0){temp.setSat(R.drawable.sat);}
        if(item.getbSun() != 0){temp.setSun(R.drawable.sun);}

        temp.setHour(item.hour);
        temp.setMinute(item.minute);
        temp.setNoon(item.noon);
        temp.setIvAlarmEdit(item.ivAlarmEdit);
        temp.setTbAlarmDeleteCheck(item.tbAlarmDeleteCheck);
        temp.setToggleButton(item.toggleButton);

        alarms.add(temp);
    }

}