package com.mycompany.weatherforecast.restapi;

import com.google.gson.Gson;
import domain.Forecast;
import domain.ForecastService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


/**
 *
 * @author Elly Goossenaerts
 */
@Path("weather")
public class ForecastController {

    @Context
    private UriInfo context;
    private ForecastService service = new ForecastService();

    public ForecastController() {
    }

    @GET
    @Path("/observation/{country}/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getObservation(@PathParam("country") String country, @PathParam("city") String city) throws Exception {
        System.out.println("In Methode");
        Gson gson = new Gson();
        Forecast fc = service.getCurrentObservation(country, city);
        String date = fc.getDateString();
        String maxTemp = fc.getMaximumTemperature();
        String minTemp = fc.getMinimumTemperature();
        String description = fc.getDescription();
        String icon = fc.getIcon();
        String country1 = fc.getCountry();
        String city1 = fc.getCity();
        Forecast forecast = new Forecast(date, maxTemp, minTemp, description, icon, country1, city1);
        String json = gson.toJson(forecast);
        String out = "{\"Observation\":" + json + "}";
        System.out.println(fc.getMinimumTemperature());
        return out;

    }

    @GET
    @Path("/forecast/{country}/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getForecast(@PathParam("country") String country, @PathParam("city") String city) throws Exception {
        System.out.println("In Methode");
        List<Forecast> f = new ArrayList<Forecast>();
        Gson gson = new Gson();
        List<Forecast> forecasts = service.getForecast(country, city);
        for (int i = 0; i < forecasts.size(); i++) {
            String date = forecasts.get(i).getDateString();
            String maxTemp = forecasts.get(i).getMaximumTemperature();
            String minTemp = forecasts.get(i).getMinimumTemperature();
            String description = forecasts.get(i).getDescription();
            String icon = forecasts.get(i).getIcon();
            String country1 = forecasts.get(i).getCountry();
            String city1 = forecasts.get(i).getCity();
            Forecast forecast = new Forecast(date, maxTemp, minTemp, description, icon, country1, city1);
            f.add(forecast);
        }
        String json = gson.toJson(f);
        String out = "{\"Forecast\":" + json + "}";
        System.out.println(f.get(0).getMinimumTemperature());
        return out;
    }
}
