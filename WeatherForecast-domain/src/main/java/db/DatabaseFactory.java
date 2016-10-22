package db;

public class DatabaseFactory {
    
    public DatabaseFactory(){}
    
    public ForecastDatabase createForecastDatabase(){
        ForecastDatabase db = new ForecastDatabase();
        return db;
    }
}
