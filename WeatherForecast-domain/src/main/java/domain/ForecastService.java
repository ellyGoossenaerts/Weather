package domain;

import db.ForecastDatabase;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ForecastService {
    
    @Inject
    private ForecastDatabase forecastDb;
    
    @Inject
    private ForecastGatherer forecastGatherer;
    

    public ForecastService(){
        System.out.println("ForeCastService constructor");
    }

    public Forecast getCurrentObservation(String country, String city) throws Exception{
        return forecastGatherer.getForecast(country, city).get(0);
    }
    
    public List<Forecast> getForecast(String country, String city) throws Exception{
        System.out.println("------------------------------------------------------------------getForecast");
        List<Forecast> forecasts = forecastGatherer.getForecast(country, city);
        addForecasts(forecasts);
        return forecasts;
    }
    
    @Schedule(second ="30", persistent = false)
    public void updateForecast() throws Exception {
        System.out.println("------------------------------------------------------------------updateForecast");
        //forecastGatherer.FakeforecastMethod();
    }
    
    public void addForecasts(List<Forecast> forecasts){
        forecastDb.createForecast(forecasts);
    }
    
    public List<Forecast> getForecasts(String country, String city){
        return forecastDb.readForecast(country, city);
    }
    
    public void updateForecast(Forecast forecast){
        forecastDb.updateForecast(forecast);
    }
    
    public void deleteForecast(String forecastDate, String country, String city){
        forecastDb.deleteForecast(forecastDate, country, city);
    }   
}
