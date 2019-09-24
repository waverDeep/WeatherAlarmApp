package com.example.weatheralarmapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class AlarmAddActivity extends AppCompatActivity {

    FragmentWeatherAlarmOpened fragmentWeatherAlarmOpened;
    FragmentWeatherAlarmClosed fragmentWeatherAlarmClosed;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_add);

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
