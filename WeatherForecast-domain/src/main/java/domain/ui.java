package domain;

import db.ForecastDatabase;
import java.io.IOException;
import java.util.ArrayList;
import org.joda.time.DateTime;


/**
 *
 * @author Eline
 */
public class ui {
    
        public static void main(String[] args) throws IOException, Exception{

             ForecastService s = new ForecastService();
             System.out.println(s.getCurrentObservation("BE", "Leuven"));
             
//  
//            ForecastDatabase db = new ForecastDatabase();       
//            DateTime date = new DateTime(2016, 10, 22, 0, 0);
//            String city = "Leuven";
//            String country = "BE";
//            String maximumTemperature = "10";
//            String max_temp = "15";
//            String minimumTemperature = "5";
//            String description = "Clear";
//            String icon = "image";
//            
//            Forecast fc1 = new Forecast(date, maximumTemperature, minimumTemperature, description, icon, country, city);
//            Forecast fc2 = new Forecast(date, maximumTemperature, minimumTemperature, description, icon, country, city);
//            ArrayList<Forecast> fcs = new ArrayList();
//            fcs.add(fc1);
//            fcs.add(fc2);
//            
//            db.createForecast(fcs);
//            System.out.println(db.readForecast(country, city));
//            
//            Forecast fc3 = new Forecast(date, max_temp, minimumTemperature, description, icon, country, city);
//            Forecast fc4 = new Forecast(date, max_temp, maximumTemperature, description, icon, country, city);
//            fcs = new ArrayList();
//            fcs.add(fc3);
//            fcs.add(fc4);
//            db.createForecast(fcs);
//            System.out.println(db.readForecast(country, city));
//            System.out.println(fc1.getDateString().equals(fc2.getDateString()));
//            System.out.println(fc1.getCity().equals(fc2.getCity()));
//            System.out.println(fc1.getCountry().equals(fc2.getCountry()));
//            System.out.println(db.getDb().keySet());
//    
//    
            
        }
    
}
