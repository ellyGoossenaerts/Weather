package domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {
    
    private String id;
    private String country;
    private String city;
    
    public Location(String country, String city){
        this.country = country;
        this.city = city;
        this.id = country + city;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }  
}
