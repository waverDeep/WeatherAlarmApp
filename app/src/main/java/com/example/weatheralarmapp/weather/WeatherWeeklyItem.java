package com.example.weatheralarmapp.weather;

public class WeatherWeeklyItem {
    private String day;
    private int highTemper;
    private int lowTemper;
    private String weather;

    public WeatherWeeklyItem(String day, int highTemper, int lowTemper, String weather) {
        this.day = day;
        this.highTemper = highTemper;
        this.lowTemper = lowTemper;
        this.weather = weather;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getHighTemper() {
        return highTemper;
    }

    public void setHighTemper(int highTemper) {
        this.highTemper = highTemper;
    }

    public int getLowTemper() {
        return lowTemper;
    }

    public void setLowTemper(int lowTemper) {
        this.lowTemper = lowTemper;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
