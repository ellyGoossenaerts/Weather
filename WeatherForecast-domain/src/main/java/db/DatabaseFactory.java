package db;

public class DatabaseFactory {
    
    public DatabaseFactory(){}
    
     public ObservationDatabase createObservationDatabase(){
        ObservationDatabase db = new ObservationDatabase("WeatherForecastPU");
        return db;
    }
    
    public ForecastDatabase createForecastDatabase(){
        ForecastDatabase db = new ForecastDatabase("WeatherForecastPU");
        return db;
    }
}
