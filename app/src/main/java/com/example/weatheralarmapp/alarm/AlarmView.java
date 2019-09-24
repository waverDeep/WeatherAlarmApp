package com.example.weatheralarmapp.alarm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.weatheralarmapp.R;


public class AlarmView extends LinearLayout {

    ImageView ivMon;
    ImageView ivTue;
    ImageView ivWed;
    ImageView ivThu;
    ImageView ivFri;
    ImageView ivSat;
    ImageView ivSun;
    TextView tvHour;
    TextView tvMinute;
    TextView tvNoon;

    ToggleButton toggleButton;
    ToggleButton tbAlarmDeleteCheck;
    ImageView ivAlarmEdit;


    public AlarmView(Context context) {
        super(context);

        init(context);
    }

    public AlarmView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listview_item_alarm, this, true);

        ivMon = (ImageView) findViewById(R.id.ivMon);
        ivTue = (ImageView) findViewById(R.id.ivTue);
        ivWed = (ImageView) findViewById(R.id.ivWed);
        ivThu = (ImageView) findViewById(R.id.ivThu);
        ivFri = (ImageView) findViewById(R.id.ivFri);
        ivSat = (ImageView) findViewById(R.id.ivSat);
        ivSun = (ImageView) findViewById(R.id.ivSun);

        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);
        tvNoon = (TextView) findViewById(R.id.tvMinute);

        toggleButton = findViewById(R.id.toggleButton);
        tbAlarmDeleteCheck = findViewById(R.id.tbAlarmDeleteCheck);
        ivAlarmEdit = findViewById(R.id.ivAlarmEdit);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = toggleButton.isChecked();
                if(state == true)
                {
                    toggleButton.setChecked(false);
                }
                else if(state == false)
                {
                    toggleButton.setChecked(true);
                }
            }
        });

        tbAlarmDeleteCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state = tbAlarmDeleteCheck.isChecked();
                if(state == true)
                {
                    tbAlarmDeleteCheck.setChecked(false);
                }
                else if(state == false)
                {
                    tbAlarmDeleteCheck.setChecked(true);
                }
            }
        });

        ivAlarmEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setHour(String hour) {
        tvHour.setText(hour);
    }

    public void setMinute(String minute) {
        tvMinute.setText(minute);
    }

    public void setNoon(String noon) {
        tvNoon.setText(noon);
    }

    public void setIvMon(ImageView ivMon) {
        ivMon.setImageResource(R.drawable.mon);
    }

    public void setIvTue(ImageView ivTue) {
        ivTue.setImageResource(R.drawable.tue);
    }

    public void setIvWed(ImageView ivWed) {
        ivWed.setImageResource(R.drawable.wed);
    }

    public void setIvThu(ImageView ivThu) {
        ivThu.setImageResource(R.drawable.thu);
    }

    public void setIvFri(ImageView ivFri) {
        ivFri.setImageResource(R.drawable.fri);
    }

    public void setIvSat(ImageView ivSat) {
        ivSat.setImageResource(R.drawable.sat);
    }

    public void setIvSun(ImageView ivSun) {
        ivSun.setImageResource(R.drawable.sun);
    }

    public void setEdit(ToggleButton toggleButton, ToggleButton tbAlarmDeleteCheck, ImageView ivAlarmEdit){
        tbAlarmDeleteCheck.setVisibility(View.VISIBLE);
        toggleButton.setVisibility(View.GONE);
        ivAlarmEdit.setVisibility(View.VISIBLE);
    }
    public void setCancle(ToggleButton toggleButton, ToggleButton tbAlarmDeleteCheck, ImageView ivAlarmEdit){
        tbAlarmDeleteCheck.setVisibility(View.GONE);
        toggleButton.setVisibility(View.VISIBLE);
        ivAlarmEdit.setVisibility(View.GONE);
    }
}