package com.example.weatheralarmapp;


import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class AlarmItem {
    String noon;
    int hour;
    int minute;
    Drawable mon;
    Drawable tue;
    Drawable wed;
    Drawable thu;
    Drawable fri;
    Drawable sat;
    Drawable sun;

    int bMon;
    int bTue;
    int bWed;
    int bThu;
    int bFri;
    int bSat;
    int bSun;

    ToggleButton toggleButton;
    ToggleButton tbAlarmDeleteCheck;
    Drawable ivAlarmEdit;

    ImageView ivMon;
    ImageView ivTue;
    ImageView ivWed;
    ImageView ivThu;
    ImageView ivFri;
    ImageView ivSat;
    ImageView ivSun;

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

    public Drawable getMon() {
        return mon;
    }

    public void setMon(Drawable mon) {
        this.mon = mon;
    }

    public Drawable getTue() {
        return tue;
    }

    public void setTue(Drawable tue) {
        this.tue = tue;
    }

    public Drawable getWed() {
        return wed;
    }

    public void setWed(Drawable wed) {
        this.wed = wed;
    }

    public Drawable getThu() {
        return thu;
    }

    public void setThu(Drawable thu) {
        this.thu = thu;
    }

    public Drawable getFri() {
        return fri;
    }

    public void setFri(Drawable fri) {
        this.fri = fri;
    }

    public Drawable getSat() {
        return sat;
    }

    public void setSat(Drawable sat) {
        this.sat = sat;
    }

    public Drawable getSun() {
        return sun;
    }

    public void setSun(Drawable sun) {
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
