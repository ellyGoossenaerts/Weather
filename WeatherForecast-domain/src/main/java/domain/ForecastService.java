package domain;

import db.ForecastDatabase;
import db.LocationDatabase;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ForecastService {
    
    @Inject
    private ForecastDatabase forecastDb;
    
    @Inject 
    private LocationDatabase locationDb;
    
    @Inject
    private ForecastGatherer forecastGatherer;
    

    public ForecastService(){
        System.out.println("ForeCastService constructor");
    }
    
    public void gatherForecasts() throws Exception{
        forecastDb.updateAll(forecastGatherer.gather(getAllLocations()));
    }
    
    public void gatherForecastFrom(Location location) throws Exception{
        addForecasts(forecastGatherer.gatherFrom(location));
    }
    
    @Schedule(second ="1", persistent = false)
    public void updateForecast() throws Exception {
        System.out.println("------------------------------------------------------------------updateForecast");
        //forecastGatherer.FakeforecastMethod();
    }
    
    public void addForecasts(List<Forecast> forecasts){
        forecastDb.createAll(forecasts);
    }
    
    public Forecast getForecastFrom(String country, String city){
        Location location = getLocation(country, city);
        return forecastDb.read(location);
    }
    
    public List<Forecast> getAllForecastsFrom(String country, String city){
        Location location = getLocation(country, city);
        return forecastDb.readAllFrom(location);
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
    
    public Location getLocation(String country, String city){
        String id = country + city;
        Location location = locationDb.read(id);
        if(location == null) location = new Location(country, city);
        return location;
    }
    
    public List<Location> getAllLocations(){
        return locationDb.readAll();
    }
    
    public void removeLocation(String id){
        locationDb.remove(id);
    }
}
