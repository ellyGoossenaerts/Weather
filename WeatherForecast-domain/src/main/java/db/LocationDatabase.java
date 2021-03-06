package db;

import domain.Location;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Elly Goossenaerts
 */
public class LocationDatabase {
    
    private final Map<String, Location> locationDb;
    
    public LocationDatabase(){
        locationDb = new HashMap();
        Location loc = new Location("BE", "Leuven");
        locationDb.put(loc.getId(), loc);
    }
    
    public void create(Location location){
        locationDb.put(location.getId(), location);
    }
    
    public Location read(String id){
        return locationDb.get(id);
    }
    
    public List<Location> readAll(){
        return new ArrayList(locationDb.values());
    }
    
    public void remove(String id){
        locationDb.remove(id);
    }
}
