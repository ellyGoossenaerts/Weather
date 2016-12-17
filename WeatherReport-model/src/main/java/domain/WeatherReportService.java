/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import db.WeatherReportDB;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Eline
 */
public class WeatherReportService {
    
    @Inject
    private WeatherReportDB db;
    
    @Inject
    private RaspberryPiGather gatherer;
    
    public WeatherReport get(long id){
        return db.get(id);
    }
    
    public List<WeatherReport> getAllWeatherReports(){
        return db.getAll();
    }
    
    public List<WeatherReport> getAllWeatherReportsBefore(Date date){
        return db.getAllWeatherReportsBefore(date);
    }
    
    public List<WeatherReport> getAllWeatherReportsAfter(Date date){
        return db.getAllWeatherReportsAfter(date);
    }
    
    public WeatherReport getWeatherReport() throws Exception{
        WeatherReport report = gatherer.gatherFrom();
        db.add(report);
        return report;
    }
    
    public void deleteWeatherReport(WeatherReport weatherReport){
        db.deleteWeatherReport(weatherReport);
    }  
}
