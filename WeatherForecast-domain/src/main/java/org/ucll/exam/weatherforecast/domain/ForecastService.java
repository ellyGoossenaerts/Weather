package org.ucll.exam.weatherforecast.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


@Path("http://api.wunderground.com/api/38f8b91ec09b4d8c/forecast/q/CA/San_Francisco.json")
public class ForecastService {
    
    Client client = ClientBuilder.newClient();
    
    WebTarget target = client.target("http://api.wunderground.com/api/38f8b91ec09b4d8c/forecast/q/CA/San_Francisco.json");    
    public ForecastService(){
        
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public void loadWeather(){
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(response);
    }
    
    public Observation getCurrentObservation(String location){
        Observation o = new Observation(location);
        return o;
    }
    
    public List<Forecast> getForecast(String location){
        List<Forecast> f = new List<>();
        return f;
    }
}
