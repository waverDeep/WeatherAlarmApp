package com.example.weatheralarmapp;


import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.weatheralarmapp.main_fragment.AlarmFragment;
import com.example.weatheralarmapp.main_fragment.MemoFragment;
import com.example.weatheralarmapp.main_fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity {

    TextView txtBottomMenuWeather, txtBottomMenuAlarm, txtBottomMenuMemo;
    ImageView imgBottomMenuWeather, imgBottomMenuAlarm, imgBottomMenuMemo;
    FrameLayout fragmentContainer;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    WeatherFragment weatherFragment;
    AlarmFragment alarmFragment;
    MemoFragment memoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitView();
        InitFragment();
        ChangeCity();
        RefreshInfo();
    }

    private void RefreshInfo() {
    }

    private void ChangeCity() {
    }

    private void InitFragment(){
        fragmentManager = getSupportFragmentManager();

        weatherFragment = new WeatherFragment();
        memoFragment = new MemoFragment();
        alarmFragment = new AlarmFragment();

        fragmentTransaction.replace(R.id.fragmentContainer, weatherFragment).commit();

    }

    private void InitView(){
        txtBottomMenuWeather = (TextView)findViewById(R.id.txtBottomMenuWeather);
        imgBottomMenuWeather = (ImageView)findViewById(R.id.imgBottomMenuWeather);
        txtBottomMenuAlarm = (TextView)findViewById(R.id.txtBottomMenuAlarm);
        imgBottomMenuAlarm = (ImageView)findViewById(R.id.imgBottomMenuAlarm);
        txtBottomMenuMemo = (TextView)findViewById(R.id.txtBottomMenuMemo);
        imgBottomMenuMemo = (ImageView)findViewById(R.id.imgBottomMenuMemo);

        txtBottomMenuWeather.setOnClickListener(bottomMenuTxtHanlder);
        txtBottomMenuMemo.setOnClickListener(bottomMenuTxtHanlder);
        txtBottomMenuAlarm.setOnClickListener(bottomMenuTxtHanlder);

        imgBottomMenuWeather.setOnClickListener(bottomMenuImgHandler);
        imgBottomMenuMemo.setOnClickListener(bottomMenuImgHandler);
        imgBottomMenuAlarm.setOnClickListener(bottomMenuImgHandler);

    }

    ImageView.OnClickListener bottomMenuImgHandler = new ImageView.OnClickListener(){
        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (v.getId())
            {
                case R.id.imgBottomMenuWeather:
                    fragmentTransaction.replace(R.id.fragmentContainer, weatherFragment).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm_g);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo_g);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textBlue));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textGray));
                    break;
                case R.id.imgBottomMenuAlarm:
                    fragmentTransaction.replace(R.id.fragmentContainer, alarmFragment).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather_g);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo_g);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textBlue));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textGray));

                    break;
                case R.id.imgBottomMenuMemo:
                    fragmentTransaction.replace(R.id.fragmentContainer, memoFragment).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather_g);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm_g);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textBlue));
                    break;
            }
        }
    };
    TextView.OnClickListener bottomMenuTxtHanlder = new TextView.OnClickListener(){

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (v.getId()){
                case R.id.txtBottomMenuWeather:
                    fragmentTransaction.replace(R.id.fragmentContainer, weatherFragment).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm_g);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo_g);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textBlue));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textGray));
                    break;
                case R.id.txtBottomMenuAlarm:
                    fragmentTransaction.replace(R.id.fragmentContainer, alarmFragment).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather_g);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo_g);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textBlue));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textGray));
                    break;
                case R.id.txtBottomMenuMemo:
                    fragmentTransaction.replace(R.id.fragmentContainer, memoFragment).commit();
                    imgBottomMenuWeather.setImageResource(R.drawable.weather_g);
                    imgBottomMenuAlarm.setImageResource(R.drawable.alarm_g);
                    imgBottomMenuMemo.setImageResource(R.drawable.memo);
                    txtBottomMenuWeather.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuAlarm.setTextColor(getResources().getColor(R.color.textGray));
                    txtBottomMenuMemo.setTextColor(getResources().getColor(R.color.textBlue));
                    break;
            }
        }
    };

}
