package db.tableDB;
import db.DatabaseException;
import db.RelationalDatabase;
import java.util.Collection;
import javax.persistence.Query;
import org.ucll.exam.weatherforecast.domain.Forecast;

public class ForecastDatabase extends RelationalDatabase{

    public ForecastDatabase(String name){
        super(name);
    }
    
    public void createForecast(Forecast forecast){
       
    }

    
}
