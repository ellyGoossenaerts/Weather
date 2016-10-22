/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.exam.weatherforecast.domain;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eline
 */
public class Controller {
    
    private String country;
    private String city;
    private ForecastService service;
    
    public Controller(){
       service = new ForecastService();
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public Observation getObservation(){
        Observation o = new Observation(this.getCity(),this.getCountry());
        return o;
    }
    
    public List<Forecast> getForecast() throws Exception{
        return this.service.getCurrentObservation(this.getObservation()).getForcasts();
    }
    
    public String printForecast(){
        String out = "";
        try {
            for(int i = 0; i < this.getForecast().size(); i++){
                //out += this.getForecast().get(i).getForecastDate().toString() + "/n";
                out += "Date: " + this.getForecast().get(i).getForecastDate() + "\n";
                out += "Weekday: "+this.getForecast().get(i).getWeekday() + "\n";
                out += "Max Temp: "+ this.getForecast().get(i).getMaximumTemperature() + "\n";
                out += "Min Temp: "+this.getForecast().get(i).getMinimumTemperature() + "\n";
                out += "Description: "+this.getForecast().get(i).getDescription() + "\n";
                //out += "Icon"+this.getForecast().get(i).getIcon() + "\n";
            }
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return out;
    }
}
