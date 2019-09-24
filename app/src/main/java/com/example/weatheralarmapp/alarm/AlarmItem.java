package com.example.weatheralarmapp.alarm;


import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.example.weatheralarmapp.R;

public class AlarmItem {
    String noon;
    int hour;
    int minute;

    int mon = R.drawable.mon_g;
    int tue = R.drawable.tue_g;
    int wed = R.drawable.wed_g;
    int thu = R.drawable.thu_g;
    int fri = R.drawable.fri_g;

    int sat = R.drawable.sat_g;
    int sun = R.drawable.sun_g;

    int bMon = 0;
    int bTue = 0;
    int bWed = 0;
    int bThu = 0;
    int bFri = 0;
    int bSat = 0;
    int bSun = 0;


    ////////view//////////
    ToggleButton toggleButton;
    ToggleButton tbAlarmDeleteCheck;
    Drawable ivAlarmEdit;



    public AlarmItem() {
    }

    public AlarmItem(String noon, int hour, int minute, int bMon, int bTue, int bWed, int bThu, int bFri, int bSat, int bSun){
        this.noon = noon;
        this.hour = hour;
        this.minute = minute;
        this.bMon = bMon;
        this.bTue = bTue;
        this.bWed = bWed;
        this.bThu = bThu;
        this.bFri = bFri;
        this.bSat = bSat;
        this.bSun = bSun;
    }

    public int getbMon() {
        return bMon;
    }

    public void setbMon(int bMon) {
        this.bMon = bMon;
    }

    public int getbTue() {
        return bTue;
    }

    public void setbTue(int bTue) {
        this.bTue = bTue;
    }

    public int getbWed() {
        return bWed;
    }

    public void setbWed(int bWed) {
        this.bWed = bWed;
    }

    public int getbThu() {
        return bThu;
    }

    public void setbThu(int bThu) {
        this.bThu = bThu;
    }

    public int getbFri() {
        return bFri;
    }

    public void setbFri(int bFri) {
        this.bFri = bFri;
    }

    public int getbSat() {
        return bSat;
    }

    public void setbSat(int bSat) {
        this.bSat = bSat;
    }

    public int getbSun() {
        return bSun;
    }

    public void setbSun(int bSun) {
        this.bSun = bSun;
    }

    public Drawable getIvAlarmEdit() {
        return ivAlarmEdit;
    }

    public void setIvAlarmEdit(Drawable ivAlarmEdit) {
        this.ivAlarmEdit = ivAlarmEdit;
    }

    public ToggleButton getToggleButton() {
        return toggleButton;
    }

    public void setToggleButton(ToggleButton toggleButton) {
        this.toggleButton = toggleButton;
    }

    public ToggleButton getTbAlarmDeleteCheck() {
        return tbAlarmDeleteCheck;
    }

    public void setTbAlarmDeleteCheck(ToggleButton tbAlarmDeleteCheck) {
        this.tbAlarmDeleteCheck = tbAlarmDeleteCheck;
    }

    public String getNoon() {
        return noon;
    }

    public void setNoon(String noon) {
        this.noon = noon;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getTue() {
        return tue;
    }

    public void setTue(int tue) {
        this.tue = tue;
    }

    public int getWed() {
        return wed;
    }

    public void setWed(int wed) {
        this.wed = wed;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public int getFri() {
        return fri;
    }

    public void setFri(int fri) {
        this.fri = fri;
    }

    public int getSat() {
        return sat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    @Override
    public String toString() {
        return "AlarmItem{" +
                "noon='" + noon + '\'' +
                ", hour=" + hour +
                ", minute=" + minute +
                ", mon=" + mon +
                ", tue=" + tue +
                ", wed=" + wed +
                ", thu=" + thu +
                ", fri=" + fri +
                ", sat=" + sat +
                ", sun=" + sun +
                ", toggleButton=" + toggleButton +
                ", tbAlarmDeleteCheck=" + tbAlarmDeleteCheck +
                ", ivAlarmEdit=" + ivAlarmEdit +
                '}';
    }
}
