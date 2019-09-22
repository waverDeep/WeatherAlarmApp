package com.example.weatheralarmapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



class AlarmAdapter extends BaseAdapter {
    ArrayList<AlarmItem> alarms = new ArrayList<AlarmItem>();

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
        final Context context = parent.getContext();

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
        hourTextView.setText(alarmitem.getHour());
        minuteTextView.setText(alarmitem.getMinute());


/*
        AlarmView view = new AlarmView(parent.getContext());

        AlarmItem item = alarms.get(position);
        view.setHour(item.getHour());
        view.setMinute(item.getMinute());
        view.setNoon(item.getNoon());
*/

        return convertView;
    }

    public void onClick(int position, AlarmItem item) {
        alarms.set(position, item);
    }

    public void addItem(AlarmItem item){
        alarms.add(item);
    }

}