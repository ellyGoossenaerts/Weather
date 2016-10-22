package org.ucll.exam.weatherforecast.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Elly Goossenaerts
 */
public class ForecastGatherer {
    
    private String url = "http://api.wunderground.com/api/38f8b91ec09b4d8c/forecast/q/{country}/{city}.json";
    private Map<String, Object> location;
    
    public ForecastGatherer(){
        location = new HashMap();
    }
    
    public Observation getCurrentObservation(Observation observation) throws Exception {
        location.put("country", observation.getCountryName());
        location.put("city", observation.getCityName());
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url).resolveTemplates(location);
        ObjectMapper objectMapper = new ObjectMapper();
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        try {
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode forecastNode = rootNode.path("forecast");
            JsonNode simpleForecastNode = forecastNode.path("simpleforecast");
            JsonNode forecastday = simpleForecastNode.path("forecastday");
            Iterator<JsonNode> elements = forecastday.elements();
            while (elements.hasNext()) {
                JsonNode actualForecast = elements.next();
                JsonNode date = actualForecast.path("date");
                JsonNode day = date.path("day");
                JsonNode month = date.path("month");
                JsonNode year = date.path("year");
                JsonNode weekday = date.path("weekday");
                JsonNode highTemp = actualForecast.path("high");
                JsonNode maxTemp = highTemp.path("celsius");
                JsonNode lowTemp = actualForecast.path("low");
                JsonNode minTemp = lowTemp.path("celsius");
                JsonNode conditions = actualForecast.path("conditions");
                JsonNode icon = actualForecast.path("icon_url");
                String forecastdate = day.intValue() + "/" + month.intValue() + "/" + year.intValue();
                Forecast forecast = new Forecast(forecastdate, maxTemp.textValue(), minTemp.textValue(), conditions.textValue(), icon.textValue(),weekday.textValue(), observation.getCountryName(), observation.getCityName());
                observation.addForecast(forecast);
            }

        } catch (Exception e) {

        }
        return observation;
    }
    
}
