package com.example.weatheralarmapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AlarmAddActivity extends AppCompatActivity {

    FragmentWeatherAlarmOpened fragmentWeatherAlarmOpened;
    FragmentWeatherAlarmClosed fragmentWeatherAlarmClosed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_add);

        fragmentWeatherAlarmClosed = (FragmentWeatherAlarmClosed)getSupportFragmentManager().findFragmentById(R.id.alarmFragmentContainer);

        fragmentWeatherAlarmOpened = new FragmentWeatherAlarmOpened();
        getSupportFragmentManager().beginTransaction().add(R.id.alarmFragmentContainer,fragmentWeatherAlarmOpened).commit();
    }

    public void onFragmentChange(int index){
        if(index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.alarmFragmentContainer, fragmentWeatherAlarmOpened).commit();
        } else if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.alarmFragmentContainer, fragmentWeatherAlarmClosed).commit();
        }
    }
}
