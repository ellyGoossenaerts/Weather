package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import domain.Forecast;
import domain.Location;


public class ForecastDatabase {
    
    private final HashMap<String, Forecast> forecastDb;

    public ForecastDatabase(){
       forecastDb = new HashMap(); 
    }
    
    public void createAll(List<Forecast> forecasts){
        for(Forecast forecast: forecasts){
            forecastDb.put(forecast.getId(), forecast);
        }
    }
    
    public Forecast read(Location location){
        for(Forecast forecast: forecastDb.values()){
            if(forecast.getLocation().equals(location) && (forecast.getDate().isEqualNow())){
                return forecast;
            }
        }
        return null;
    }
    
    public List<Forecast> readAllFrom(Location location){
        List<Forecast> forecasts = new ArrayList();
        for(Forecast forecast: forecastDb.values()){
            if(forecast.getLocation().equals(location) && (forecast.getDate().isEqualNow() || forecast.getDate().isAfterNow())){
                forecasts.add(forecast);
            }
        }
        return forecasts;
    }
    
    public void updateAll(List<Forecast> forecasts){
        for(Forecast forecast: forecasts){
            forecastDb.put(forecast.getId(), forecast);
        }
    }
    
    public void delete(String id){
        forecastDb.remove(id);
    }  
}
