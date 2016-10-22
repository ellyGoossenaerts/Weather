/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.exam.weatherforecast.domain;

import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author Eline
 */
public class Forecast {
    
    private String forecastDate;
    private String cityName;
    private String countryName;
    private String maximumTemperature;
    private String minimumTemperature;
    private String description;
    private String icon;
    private String weekday;

    
    public Forecast(){
        
    }

    public Forecast(String forecastDate, String maximumTemperature, String minimumTemperature, String description, String icon, String weekday, String CountryName, String cityName) {
        this.forecastDate = forecastDate;
        this.maximumTemperature = maximumTemperature;
        this.minimumTemperature = minimumTemperature;
        this.description = description;
        this.icon = icon;
        this.weekday = weekday;
        this.countryName = countryName;
        this.cityName = cityName;  
    }

    public String getForecastDate() {
        return forecastDate;
    }


    public String getMaximumTemperature() {
        return maximumTemperature;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getMinimumTemperature() {
        return minimumTemperature;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCityName() {
        return cityName;
    }
}
