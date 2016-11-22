package domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.ForecastDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.joda.time.DateTime;

/**
 *
 * @author Elly Goossenaerts
 */

//@Stateless
public class ForecastGatherer {

    private String url = "http://api.wunderground.com/api/38f8b91ec09b4d8c/forecast/q/{country}/{city}.json";
    Map<String, Object> location = new HashMap();

    public ForecastGatherer() {

    }

    public List<Forecast> gather(List<Location> locations) throws Exception {
        List<Forecast> forecasts = new ArrayList();

        for (Location location : locations) {
            forecasts.addAll(gatherFrom(location));
        }
        return forecasts;
    }
            
    public List<Forecast> gatherFrom(Location location) throws Exception {
        this.location.put("country", location.getCountry());
        this.location.put("city", location.getCity());
        List<Forecast> forecasts = new ArrayList();
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url).resolveTemplates(this.location);
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
                JsonNode highTemp = actualForecast.path("high");
                JsonNode maxTemp = highTemp.path("celsius");
                JsonNode lowTemp = actualForecast.path("low");
                JsonNode minTemp = lowTemp.path("celsius");
                JsonNode conditions = actualForecast.path("conditions");
                JsonNode icon = actualForecast.path("icon_url");
                DateTime fcDate = new DateTime(year.intValue(), month.intValue(), day.intValue(), 0, 0);
                Forecast forecast = new Forecast(fcDate, maxTemp.textValue(), minTemp.textValue(), conditions.textValue(), icon.textValue(), location);
                forecasts.add(forecast);
            }

        } catch (Exception e) {

        }
        return forecasts;
    }   
}

