package com.example.weatheralarmapp.alarm;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weatheralarmapp.R;
import com.example.weatheralarmapp.alarm.AlarmAddActivity;

public class WeatherAlarmClosedFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_weather_alarm_closed, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.imgWeatherAlarmOpen);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmAddActivity alarmAddActivity = (AlarmAddActivity) getActivity();
//                Toast.makeText(getContext(), "Closed", Toast.LENGTH_LONG).show();
                Log.d("Closed", "closed");
                alarmAddActivity.onFragmentChange(0);
            }
        });

        return rootView;
    }
}
