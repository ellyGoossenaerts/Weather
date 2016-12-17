/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author Eline
 */
public class WeatherReportDBFactory {
    
    public WeatherReportDB createDatabase(String type){
        WeatherReportDB db = null;
        if(type.equals("JPA")){
            db = new WeatherReportDB("WeatherPU");
        }
        return db;
    }
}
