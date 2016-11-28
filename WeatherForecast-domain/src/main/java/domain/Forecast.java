package domain;

import javax.xml.bind.annotation.XmlRootElement;
import org.joda.time.DateTime;


/**
 *
 * @author Eline
 */
@XmlRootElement()
public class Forecast {
    
    private String id;
    private DateTime date;
    private Location location;
    private String maximumTemperature;
    private String minimumTemperature;
    private String description;
    private String icon;
    
    public Forecast(){
        
    }

    public Forecast(DateTime date, String maxTemp, String minTemp, String description, String icon, Location location) {
        this.date = date;
        this.maximumTemperature = maxTemp;
        this.minimumTemperature = minTemp;
        this.description = description;
        this.icon = icon;
        this.location = location;
        setId();
    }
    
    private void setId(){
        id = location.getId() + getDateString();
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public DateTime getDate() {
        return date;
    }
    
    public String getDateString() {
        return date.toString("dd/MM/yyyy");
    }
    
    public String getWeekday(){
        return date.dayOfWeek().getAsText();
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
        return date.getYear() == DateTime.now().getYear() && date.dayOfYear().equals(DateTime.now().dayOfYear());
    }
    
    @Override
    public String toString(){
        return id;
    }
}
