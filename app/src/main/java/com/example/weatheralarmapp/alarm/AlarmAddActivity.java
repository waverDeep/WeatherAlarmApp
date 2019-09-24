package com.example.weatheralarmapp.alarm;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatheralarmapp.R;

public class AlarmAddActivity extends AppCompatActivity {

    WeatherAlarmOpenedFragment weatherAlarmOpenedFragment;
    WeatherAlarmClosedFragment weatherAlarmClosedFragment;

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

        tvAlarmEditCancel = findViewById(R.id.tvAlarmEditCancel);
        tvAlarmEditSave = findViewById(R.id.tvAlarmEditSave);

        imgRepeatMon = findViewById(R.id.imgRepeatMon);
        imgRepeatTue = findViewById(R.id.imgRepeatTue);
        imgRepeatWed = findViewById(R.id.imgRepeatWed);
        imgRepeatThur = findViewById(R.id.imgRepeatThur);
        imgRepeatFri = findViewById(R.id.imgRepeatFri);
        imgRepeatSat = findViewById(R.id.imgRepeatSat);
        imgRepeatSun = findViewById(R.id.imgRepeatSun);

        if (findViewById(R.id.fragmentWeatherAlarm) != null)
        {
            if(savedInstanceState != null)
            {
                return;
            }

            weatherAlarmClosedFragment = new WeatherAlarmClosedFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentWeatherAlarm, weatherAlarmClosedFragment).commit();
        }

        weatherAlarmOpenedFragment = new WeatherAlarmOpenedFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.alarmFragmentContainer,weatherAlarmOpenedFragment).commit();




    }

    public void onFragmentChange(int index){
        if(index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentWeatherAlarm, weatherAlarmOpenedFragment).commit();
        } else if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentWeatherAlarm, weatherAlarmClosedFragment).commit();
        }
    }
}
