package db;

public class DatabaseFactory {
    
    public DatabaseFactory(){}
    
     public ObservationDatabase createObservationDatabase(){
        ObservationDatabase db = new ObservationDatabase();
        return db;
    }
    
    public ForecastDatabase createForecastDatabase(){
        ForecastDatabase db = new ForecastDatabase();
        return db;
    }
}
