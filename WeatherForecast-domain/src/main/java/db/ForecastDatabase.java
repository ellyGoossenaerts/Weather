package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ucll.exam.weatherforecast.domain.Forecast;

public class ForecastDatabase {
    
    private HashMap<String[], Forecast> forecastDb;

    public ForecastDatabase(){
       forecastDb = new HashMap(); 
    }
    
    public void createForecast(List<Forecast> forecasts){
        for(Forecast forecast: forecasts){
            forecastDb.put(createId(forecast.getDateString(), forecast.getCountry(), forecast.getCity()), forecast);
        }
    }
    
    public List<Forecast> readForecast(String country, String city){
        List<Forecast> forecasts = new ArrayList();
        for(Forecast forecast: forecastDb.values()){
            if(forecast.getCountry().equals(country) && forecast.getCity().equals(city)){
                forecasts.add(forecast);
            }
        }
        return forecasts;
    }
    
    public void updateForecast(Forecast forecast){
        forecastDb.put(createId(forecast.getDateString(), forecast.getCountry(), forecast.getCity()), forecast);
    }
    
    public void deleteForecast(String forecastDate, String country, String city){
        forecastDb.remove(createId(forecastDate, country, city));
    }  
    
    private String[] createId(String forecastDate, String country, String city){
        String[] id = new String[3];
        id[0] = forecastDate;
        id[1] = country;
        id[2] = city;
        return id;
    }
}
