/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.exam.weatherforecast.domain;

import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author Eline
 */
public class Forecast {
    
    private DateTime time;
    private String location;
    private Date forecastDate;
    private int maximumTemperature;
    
    public Forecast(){
        
    }
    
}
