package com.example.weatheralarmapp.weather;

public class WeatherDailyItem {
    private String time;
    private String temper;
    private String aboutRain;
    private String weather;

    public WeatherDailyItem(String time, String temper, String aboutRain, String weather) {
        this.time = time;
        this.temper = temper;
        this.weather = weather;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getAboutRain() {
        return aboutRain;
    }

    public void setAboutRain(String aboutRain) {
        this.aboutRain = aboutRain;
    }
}
