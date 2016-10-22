package org.ucll.exam.weatherforecast.domain;

import org.joda.time.DateTime;


/**
 *
 * @author Eline
 */
public class Forecast {
    
    private DateTime date;
    private String city;
    private String country;
    private String maximumTemperature;
    private String minimumTemperature;
    private String description;
    private String icon;
    
    public Forecast(){
        
    }

    public Forecast(DateTime date, String maxTemp, String minTemp, String description, String icon, String country, String city) {
        this.date = date;
        this.maximumTemperature = maxTemp;
        this.minimumTemperature = minTemp;
        this.description = description;
        this.icon = icon;
        this.country = country;
        this.city = city;  
    }

    public DateTime getDate() {
        return date;
    }
    
    public String getDateString() {
        return date.toString("dd/MM/yyyy");
    }
    
    public String getWeekday(){
        return date.dayOfWeek().getAsText();
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

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
