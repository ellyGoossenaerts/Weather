/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.raspberrypiinformation;

/**
 *
 * @author Eline
 */
public class Temperature {
    
    private double temp;
    private String humidity;

    public Temperature() {
    }

    public Temperature(double temp, String humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }

    public String getHumidity() {
        return humidity;
    }

    public double getTemp() {
        return temp;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
    
    
    
}
