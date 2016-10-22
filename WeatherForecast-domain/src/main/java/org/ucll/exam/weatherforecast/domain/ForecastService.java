package org.ucll.exam.weatherforecast.domain;

import db.ForecastDatabase;
import db.ObservationDatabase;
import java.util.List;


public class ForecastService {

    private final ForecastDatabase forecastDb;
    private final ObservationDatabase observationDb;
    private final ForecastGatherer forecastGatherer;
    

    public ForecastService() {
        forecastDb = new ForecastDatabase();
        observationDb = new ObservationDatabase();
        forecastGatherer = new ForecastGatherer();
    }

    public Observation getCurrentObservation(String country, String city) throws Exception{
        if(getObservation(country, city) == null) addObservation(new Observation(country, city)); 
        return forecastGatherer.getCurrentObservation(getObservation(country, city));
    }
    
    public void addForecast(Forecast forecast){
        forecastDb.createForecast(forecast);
    }
    
    public List<Forecast> getForecast(String cityName, String cityCountry){
        return forecastDb.readForecast(cityName, cityCountry);
    }
    
    public void updateForecast(Forecast forecast){
        forecastDb.updateForecast(forecast);
    }
    
    public void deleteForecast(String forecastDate, String country, String city){
        forecastDb.deleteForecast(forecastDate, country, city);
    }
    
    public void addObservation(Observation observation){
        observationDb.createObservation(observation);
    }
    
    public Observation getObservation(String countryName, String cityName){
        return observationDb.readObservation(countryName, cityName);
    }
    
    public void updateObservation(Observation observation){
        observationDb.updateObservation(observation);
    }
    
    public void removeObservation(String countryName, String cityName){
        observationDb.removeObservation(countryName, cityName);
    }
    

    
}
