package com.example.weatheralarmapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlarmAddActivity extends AppCompatActivity {

    FragmentWeatherAlarmOpened fragmentWeatherAlarmOpened;
    FragmentWeatherAlarmClosed fragmentWeatherAlarmClosed;

    TextView tvAlarmEditCancel;
    TextView tvAlarmEditSave;

    ImageView imgRepeatMon;
    ImageView imgRepeatTue;
    ImageView imgRepeatWed;
    ImageView imgRepeatThur;
    ImageView imgRepeatFri;
    ImageView imgRepeatSat;
    ImageView imgRepeatSun;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_add);

        tvAlarmEditCancel = (TextView)findViewById(R.id.tvAlarmEditCancel);
        tvAlarmEditSave = (TextView)findViewById(R.id.tvAlarmEditSave);

        imgRepeatMon = (ImageView)findViewById(R.id.imgRepeatMon);
        imgRepeatTue = (ImageView)findViewById(R.id.imgRepeatTue);
        imgRepeatWed = (ImageView)findViewById(R.id.imgRepeatWed);
        imgRepeatThur = (ImageView)findViewById(R.id.imgRepeatThur);
        imgRepeatFri = (ImageView)findViewById(R.id.imgRepeatFri);
        imgRepeatSat = (ImageView)findViewById(R.id.imgRepeatSat);
        imgRepeatSun = (ImageView)findViewById(R.id.imgRepeatSun);


//        fragmentWeatherAlarmClosed = (FragmentWeatherAlarmClosed)getSupportFragmentManager().findFragmentById(R.id.fragmentWeatherAlarm);

        if (findViewById(R.id.fragmentWeatherAlarm) != null)
        {
            if(savedInstanceState != null)
            {
                return;
            }

            fragmentWeatherAlarmClosed = new FragmentWeatherAlarmClosed();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentWeatherAlarm,fragmentWeatherAlarmClosed).commit();
        }

        fragmentWeatherAlarmOpened = new FragmentWeatherAlarmOpened();
//        getSupportFragmentManager().beginTransaction().add(R.id.alarmFragmentContainer,fragmentWeatherAlarmOpened).commit();




    }

    public void onFragmentChange(int index){
        if(index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentWeatherAlarm, fragmentWeatherAlarmOpened).commit();
        } else if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentWeatherAlarm, fragmentWeatherAlarmClosed).commit();
        }
    }
}
