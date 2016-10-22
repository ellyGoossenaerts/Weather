package org.ucll.exam.weatherforecast.domain;

import java.io.IOException;
import org.joda.time.DateTime;


/**
 *
 * @author Eline
 */
public class ui {
    
        public static void main(String[] args) throws IOException, Exception{
            
            //ForecastService service = new ForecastService();
            //Observation c = new Observation("Leuven","BE");
            //service.getCityForecast(c);
            
            //System.out.println(service.getCurrentObservation(c).getForcasts());
            DateTime dateTime = new DateTime(2016, 10, 22, 0, 0);
            System.out.println(dateTime.dayOfWeek().getAsText());
            System.out.println(dateTime.toString("dd/MM/yyyy"));
            
        }
    
}
