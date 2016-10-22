package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ucll.exam.weatherforecast.domain.Forecast;

public class ForecastDatabase {
    
    private HashMap<String, Forecast> forecastDb;

    public ForecastDatabase(){
       forecastDb = new HashMap(); 
    }
    
    public void createForecast(Forecast forecast){
        forecastDb.put(forecast.getForecastDate(), forecast);
    }
    
    public List<Forecast> readForecast(String cityName, String cityCountry){
        List<Forecast> forecasts = new ArrayList();
        for(Forecast forecast: forecastDb.values()){
            if(forecast.getCityCountry().equals(cityCountry) && forecast.getCityName().equals(cityName)){
                forecasts.add(forecast);
            }
        }
        return forecasts;
    }
    
    public void updateForecast(Forecast forecast){
        forecastDb.put(forecast.getForecastDate(), forecast);
    }
    
    public void deleteForecast(String id){
        forecastDb.remove(id);
    }  
}
