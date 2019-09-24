package com.example.weatheralarmapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.weatheralarmapp.DB.AlarmDBHelper;

import java.util.ArrayList;


public class FragmentAlarm extends Fragment {

    View view;

    TextView tvEdit;
    TextView tvAlarm;
    TextView tvPlus;
    TextView tvCancle;

    ListView listAlarm;

    AlarmAdapter adapter;

    String noon;
    String hour;
    String minute;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_alarm, container, false);

        tvEdit = (TextView) view.findViewById(R.id.tvEdit);
        tvAlarm = (TextView) view.findViewById(R.id.tvAlarm);
        tvPlus = (TextView) view.findViewById(R.id.tvPlus);
        tvCancle = (TextView) view.findViewById(R.id.tvCancle);
        listAlarm = (ListView) view.findViewById(R.id.listAlarm);

 //       toggleButton = (ToggleButton) view.findViewById(R.id.toggleButton);
 //       tbAlarmDeleteCheck = (ToggleButton) view.findViewById(R.id.tbAlarmDeleteCheck);

        adapter = new AlarmAdapter();

        listAlarm.setAdapter(adapter);

        AlarmDBHelper db = new AlarmDBHelper(getContext());
        AlarmItem alarm = db.readAlarm(db);
        adapter.addItem(alarm); //여기서는 db에 있는 내용으로 받아와서 넣기

        /* 리스트 자체 클릭 기능은 없다
        listAlarm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlarmItem item = (AlarmItem) adapter.getItem(position);

                /*
                이건 나중에 받을 때 쓸거
                noon = item.getNoon();
                hour = item.getHour();
                minute = item.getMinute();
                item.setNoon(noon);
                item.setHour(hour);
                item.setMinute(minute);

                Intent intent = new Intent(parent.getContext(), null); //알림편집으로 넘어가야함
                intent.putExtra("Noon", item.getNoon());
                intent.putExtra("Hour", item.getHour());
                intent.putExtra("Minute", item.getMinute());
                startActivity(intent);
                */
/*
                folder_name = tvMemoName.getText().toString();
                memo_title = memoNameItem.getTitle();

                Intent intent = new Intent(getApplicationContext(), MemoWriteActivity.class);
                intent.putExtra("folder_name", folder_name);
                intent.putExtra("memo_title", memo_title);
                intent.putExtra("click", "item");
                startActivity(intent);

            }
        });
*/



        tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvEdit.setVisibility(View.GONE);
                tvCancle.setVisibility(View.VISIBLE);

                ImageView ivAlarmEdit = (ImageView) view.findViewById(R.id.ivAlarmEdit);
                ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.toggleButton);
                ToggleButton tbAlarmDeleteCheck = (ToggleButton) view.findViewById(R.id.tbAlarmDeleteCheck);

                tbAlarmDeleteCheck.setVisibility(View.VISIBLE);
                toggleButton.setVisibility(View.GONE);
                ivAlarmEdit.setVisibility(View.VISIBLE);

            }
        });

        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEdit.setVisibility(View.VISIBLE);
                tvCancle.setVisibility(View.GONE);
                ImageView ivAlarmEdit = (ImageView) view.findViewById(R.id.ivAlarmEdit);
                ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.toggleButton);
                ToggleButton tbAlarmDeleteCheck = (ToggleButton) view.findViewById(R.id.tbAlarmDeleteCheck);
                tbAlarmDeleteCheck.setVisibility(View.GONE);
                toggleButton.setVisibility(View.VISIBLE);
                ivAlarmEdit.setVisibility(View.GONE);
            }
        });

        tvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AlarmAddActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }




}


