package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.xml.bind.annotation.XmlRootElement;
import org.joda.time.DateTime;


/**
 *
 * @author Eline
 */
@XmlRootElement()
public class Forecast {
    
    private String id;
    private DateTime datum;
    private LocalDate date;
    private LocalTime time;
    private Location location;
    private String maximumTemperature;
    private String minimumTemperature;
    private String description;
    private String icon;
    
    public Forecast(){
        
    }

    public Forecast(DateTime date, String maxTemp, String minTemp, String description, String icon, Location location) {
        this.datum = date;
        this.maximumTemperature = maxTemp;
        this.minimumTemperature = minTemp;
        this.description = description;
        this.icon = icon;
        this.location = location;
        setId();
    }
    
    private void setId(){
        id = location.getId() + datum.toString();
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public DateTime getDatum() {
        return datum;
    }
    
    public String getDateString() {
        return datum.toString("dd/MM/yyyy");
    }
    
    public String getWeekday(){
        return datum.dayOfWeek().getAsText();
    }

    public String getMaximumTemperature() {
        return maximumTemperature;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getMinimumTemperature() {
        return minimumTemperature;
    }
    
    public boolean isToday(){
        return datum.getYear() == DateTime.now().getYear() && datum.dayOfYear().equals(DateTime.now().dayOfYear());
    }
    
    @Override
    public String toString(){
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
    
    
}
