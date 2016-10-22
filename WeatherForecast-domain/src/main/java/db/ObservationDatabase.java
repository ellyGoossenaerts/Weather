package db;

import java.util.HashMap;
import org.ucll.exam.weatherforecast.domain.Observation;

public class ObservationDatabase {
    
    private HashMap<String[], Observation> observationDb;
    
    public void ObservationDatabase(){
        observationDb = new HashMap();
    }
    
    public void createObservation(Observation observation){
        observationDb.put(createId(observation.getCountryName(), observation.getCityName()), observation);
    }
    
    public Observation readObservation(String countryName, String cityName){
        return observationDb.get(createId(countryName, cityName));
    }
    
    public void updateObservation(Observation observation){
        observationDb.put(createId(observation.getCountryName(), observation.getCityName()), observation);
    }
    
    public void removeObservation(String countryName, String cityName){
        observationDb.remove(createId(countryName, cityName));
    }
    
    private String[] createId(String countryName, String cityName){
        String[] id = new String[2];
        id[0] = countryName;
        id[1] = cityName;
        return id;
    }
    
}
