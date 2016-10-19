/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.exam.weatherforecast.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eline
 */
public class Observation {
    
    private String cityName;
    private String countryName;
    private List<Forecast> forcasts;
    
    public Observation(String cityName, String countryName){
        this.cityName = cityName;
        this.countryName = countryName;
        this.forcasts = new ArrayList<>();
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public List<Forecast> getForcasts() {
        return forcasts;
    }
    
    public void addForecast(Forecast f){
        this.forcasts.add(f);
    }
    
    
}
