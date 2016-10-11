/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.exam.weatherforecast.domain;

import org.joda.time.DateTime;

/**
 *
 * @author Eline
 */
public class Observation {
    
    private DateTime time;
    private String location;
    private int temperature;
    
    public Observation(){
        
    }
    
    public Observation(String location){
        this.location = location;
    }
    
    
}
