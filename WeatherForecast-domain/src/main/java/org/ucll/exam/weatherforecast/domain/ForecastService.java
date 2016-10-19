package org.ucll.exam.weatherforecast.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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



public class ForecastService {
    
    private final String url = "http://api.wunderground.com/api/38f8b91ec09b4d8c/forecast/q/";
    
    public ForecastService(){
        
    }
    
    public City getCityForecast(City city)throws Exception{
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target("http://api.wunderground.com/api/38f8b91ec09b4d8c/forecast/q/CA/San_Francisco.json");    
    ObjectMapper objectMapper = new ObjectMapper();
    String response=target.request(MediaType.APPLICATION_JSON).get(String.class);
    City cityresp=new City(city.getCountryName(),city.getCityName());
    try{
        JsonNode rootNode=objectMapper.readTree(response);
        JsonNode forecastNode=rootNode.path("forecast");
        JsonNode simpleForecastNode=forecastNode.path("simpleforecast");
        JsonNode forecastday=simpleForecastNode.path("forecastday");
            Iterator<JsonNode> elements=forecastday.elements();
            System.out.println("This still works");
            //Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            int day = 0;
            while(elements.hasNext()){
              JsonNode actualForecast=elements.next();
              JsonNode highTemp = actualForecast.path("high");
              JsonNode maxTemp = highTemp.path("celcius");
              JsonNode lowTemp = actualForecast.path("low");
              JsonNode minTemp = lowTemp.path("celcius");
              JsonNode conditions = actualForecast.path("conditions");
              JsonNode icon = actualForecast.path("icon_url");
              c.add(Calendar.DATE, day);
              Forecast forecast = new Forecast(c,maxTemp.intValue(),minTemp.intValue(),conditions.textValue(),icon.textValue());
              day++;
            }
        
    }catch(Exception e){
        
    }
    return cityresp;
    }
    
    public void loadWeather(){
      //  String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        
        //System.out.println(response);
    }
    
    public Observation getCurrentObservation(String location){
        Observation o = new Observation(location);
        return o;
    }
    
    //public List<Forecast> getForecast(String location){
    //    List<Forecast> f = new List<Forecast>();
    //    return f;
   // }
}
