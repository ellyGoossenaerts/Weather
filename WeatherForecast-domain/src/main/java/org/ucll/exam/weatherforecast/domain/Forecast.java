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
    
    private Calendar forecastDate;
    private int maximumTemperature;
    private int minimumTemperature;
    private String description;
    private String icon;
    
    public Forecast(){
        
    }

    public Forecast( Calendar forecastDate, int maximumTemperature, int minimumTemperature, String description, String icon) {
        this.forecastDate = forecastDate;
        this.maximumTemperature = maximumTemperature;
        this.minimumTemperature = minimumTemperature;
        this.description = description;
        this.icon = icon;
    }

    public Calendar getForecastDate() {
        return forecastDate;
    }


    public int getMaximumTemperature() {
        return maximumTemperature;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public int getMinimumTemperature() {
        return minimumTemperature;
    }

    
    
    
    
    
    
    
    
    
}
