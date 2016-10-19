package org.ucll.exam.weatherforecast.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ForecastService {

    private final String url = "http://api.wunderground.com/api/38f8b91ec09b4d8c/forecast/q/";

    public ForecastService() {

    }

    public City getCityForecast(City city) throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://api.wunderground.com/api/38f8b91ec09b4d8c/forecast/q/CA/San_Francisco.json");
        ObjectMapper objectMapper = new ObjectMapper();
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        City cityresp = new City(city.getCountryName(), city.getCityName());
        try {
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode forecastNode = rootNode.path("forecast");
            JsonNode simpleForecastNode = forecastNode.path("simpleforecast");
            JsonNode forecastday = simpleForecastNode.path("forecastday");
            Iterator<JsonNode> elements = forecastday.elements();
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            int day = 0;
            while (elements.hasNext()) {
                JsonNode actualForecast = elements.next();
                JsonNode highTemp = actualForecast.path("high");
                JsonNode maxTemp = highTemp.path("celsius");
                JsonNode lowTemp = actualForecast.path("low");
                JsonNode minTemp = lowTemp.path("celsius");
                JsonNode conditions = actualForecast.path("conditions");
                JsonNode icon = actualForecast.path("icon_url");
                c.add(Calendar.DATE, day);
                Forecast forecast = new Forecast(c, maxTemp.intValue(), minTemp.intValue(), conditions.textValue(), icon.textValue());
                cityresp.addForecast(forecast);
                day++;
            }

        } catch (Exception e) {

        }
        return cityresp;
    }

    //public List<Forecast> getForecast(String location){
    //    List<Forecast> f = new List<Forecast>();
    //    return f;
    // }
}
