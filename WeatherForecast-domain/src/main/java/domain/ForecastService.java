package domain;

import db.ForecastDatabase;
import db.LocationDatabase;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Singleton
public class ForecastService {
    
    @Inject
    private ForecastDatabase forecastDb;
    
    @Inject 
    private LocationDatabase locationDb;
    
    @EJB
    private ForecastGatherer forecastGatherer;
    

    public ForecastService(){
        System.out.println("ForeCastService constructor");
    }
    
    @Schedule(second ="*/30", minute="*", hour="*", persistent = false)
    public void gatherForecasts() throws Exception{
        forecastDb.updateAll(forecastGatherer.gather(getAllLocations()));
        System.out.println("-------Forecasts: " + getAllForecasts());
    }
    
    public void gatherForecastFrom(Location location) throws Exception{
        addForecasts(forecastGatherer.gatherFrom(location));
    }
    
    public void addForecasts(List<Forecast> forecasts){
        forecastDb.createAll(forecasts);
    }
    
    public Forecast getForecastFrom(String country, String city) throws Exception{
        Location location = getLocation(country, city);
        return forecastDb.read(location);
    }
    
    public List<Forecast> getAllForecastsFrom(String country, String city) throws Exception{
        Location location = getLocation(country, city);
        return forecastDb.readAllFrom(location);
    }
    
    public List<Forecast> getAllForecasts(){
        return forecastDb.readAll();
    }
    
    public void updateForecasts(List<Forecast> forecasts){
        forecastDb.updateAll(forecasts);
    }
    
    public void deleteForecast(String id){
        forecastDb.delete(id);
    }   
    
    public void addLocation(Location location) throws Exception{
        locationDb.create(location);
        gatherForecastFrom(location);
    }
    
    public Location getLocation(String country, String city) throws Exception{
        String id = country + city;
        Location location = locationDb.read(id);
        if(location == null) location = new Location(country, city);
        addLocation(location);
        return location;
    }
    
    public List<Location> getAllLocations(){
        return locationDb.readAll();
    }
    
    public void removeLocation(String id){
        locationDb.remove(id);
    }
}
