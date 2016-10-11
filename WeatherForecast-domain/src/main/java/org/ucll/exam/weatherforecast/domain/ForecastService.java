package org.ucll.exam.weatherforecast.domain;

import java.util.LinkedHashMap;

public class ForecastService {
    
    public ForecastService(){
        
    }
    
    public void loadWeather(){
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper jacksonObjectMapper = new ObjectMapper();
        LinkedHashMap map = restTemplate.getForObject("");
        
    }
}
