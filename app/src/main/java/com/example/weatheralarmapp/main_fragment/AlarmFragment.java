package com.example.weatheralarmapp.main_fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weatheralarmapp.alarm.AlarmAdapter;
import com.example.weatheralarmapp.alarm.AlarmAddActivity;
import com.example.weatheralarmapp.alarm.AlarmItem;
import com.example.weatheralarmapp.R;
import com.example.weatheralarmapp.db_connect.DBConst;
import com.example.weatheralarmapp.db_connect.DBHelper;

import java.util.ArrayList;


public class AlarmFragment extends Fragment {

    View view;
    Context context;

    TextView tvEdit;
    TextView tvAlarm;
    TextView tvPlus;
    TextView tvCancel;

    ListView listAlarm;

    AlarmAdapter adapter;

    String noon;
    String hour;
    String minute;

    // 형 텍스트뷰를 2개 만들어서 보였다 안보였다가 하면 나중에 지금 현 상태가 편집모드인지 아니면 기본모드인지 상태파악하기가 엄청 곤란해져요
    // 어차피 여기는 텍스트만 바뀌는 거니까
    // false 일때 일반모드 text는 편집
    // true 일때 수정모드 text는 취소
    // 로작업하는게 좋습니다.
    boolean editStatus = false;

    DBHelper dbHelper;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();

        dbHelper = new DBHelper(context.getApplicationContext(), DBConst.ALARM_TABLE_NAME, null, DBConst.DATABASE_VERSION);

        view = inflater.inflate(R.layout.fragment_alarm, container, false);

        tvEdit = view.findViewById(R.id.tvEdit); //편집
        tvAlarm = view.findViewById(R.id.tvAlarm); //알람
        tvPlus = view.findViewById(R.id.tvPlus); //추가
        listAlarm = view.findViewById(R.id.listAlarm);


        adapter = new AlarmAdapter();

        dbHelper.addContact("오전", 8, 10, 1, 1,0,1, 1, 1, 0, 0, "wea");
        dbHelper.addContact("오전", 8, 10, 1, 1,0,1, 1, 1, 0, 0, "wea");
        dbHelper.addContact("오전", 8, 10, 1, 1,0,1, 1, 1, 0, 0, "wea");
        dbHelper.addContact("오전", 8, 10, 1, 1,0,1, 1, 1, 0, 0, "wea");

//        adapter.addItem(new AlarmItem("오전", 8, 10, 1, 1,0,1, 1, 1, 0));
//        adapter.addItem(new AlarmItem("오전", 8, 10, 1, 1,0,1, 1, 1, 0));
//        adapter.addItem(new AlarmItem("오전", 8, 10, 1, 1,0,1, 1, 1, 0));
//        adapter.addItem(new AlarmItem("오전", 8, 10, 1, 1,0,1, 1, 1, 0));
//        adapter.addItem(new AlarmItem("오전", 8, 10, 1, 1,0,1, 1, 1, 0));
//        adapter.addItem(new AlarmItem("오전", 8, 10, 1, 1,0,1, 1, 1, 0));

        ArrayList<AlarmItem> alarmItems = dbHelper.readContact();

        for (AlarmItem item : alarmItems){
            adapter.addItem(item);
        }

        listAlarm.setAdapter(adapter);
//
//        DBHelper db = new DBHelper(getContext());
//        AlarmItem alarm = db.readAlarm(db);
//        adapter.addItem(alarm); //여기서는 db에 있는 내용으로 받아와서 넣기


        //편집 버튼을 눌렀을때 취소 버튼으로 바뀌는 이벤트 리스너
        tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!editStatus){
                    //만약 editStatus가 false 라면 텍스트를 취소로 바꾸고 editStatus를 수정 모드인 true로 바꾼다.
                    tvEdit.setText("취소");
                    editStatus = !editStatus;
                }else{
                    //만약 editStatus가 true 라면 텍스트를 편집으로 바꾸고 editStatus를 다시 일반 모드인 false 로 바꾼다.
                    tvEdit.setText("편집");
                    editStatus = !editStatus;
                }
//                tvEdit.setVisibility(View.GONE);
//                tvCancel.setVisibility(View.VISIBLE);
//
//                ImageView ivAlarmEdit = (ImageView) view.findViewById(R.id.ivAlarmEdit);
//                ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.toggleButton);
//                ToggleButton tbAlarmDeleteCheck = (ToggleButton) view.findViewById(R.id.tbAlarmDeleteCheck);
//
//                tbAlarmDeleteCheck.setVisibility(View.VISIBLE);
//                toggleButton.setVisibility(View.GONE);
//                ivAlarmEdit.setVisibility(View.VISIBLE);

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


