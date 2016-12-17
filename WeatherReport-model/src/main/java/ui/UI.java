/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import db.WeatherReportDB;
import domain.WeatherReport;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/**
 *
 * @author Eline
 */
public class UI {
    
    public static void main(String[] args){
        WeatherReportDB db = new WeatherReportDB("WeatherPU");
        
        WeatherReport w = new WeatherReport(20,"52.2",LocalDate.now(),LocalTime.now());
        db.add(w);
    }
}
