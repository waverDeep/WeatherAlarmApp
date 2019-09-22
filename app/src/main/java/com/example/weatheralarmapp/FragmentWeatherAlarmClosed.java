package com.example.weatheralarmapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentWeatherAlarmClosed extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_weather_alarm_closed, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.imgWeatherAlarmOpen);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmAddActivity alarmAddActivity = (AlarmAddActivity) getActivity();
                alarmAddActivity.onFragmentChange(0);
            }
        });

        return rootView;
    }
}
