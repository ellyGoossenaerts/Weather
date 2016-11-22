package com.mycompany.weatherforecast.restapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.ForecastService;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.joda.time.DateTime;


/**
 *
 * @author Elly Goossenaerts
 */
@Path("weather")
public class ForecastController {

    @Context
    private UriInfo context;
    @EJB
    private ForecastService service;
    @Inject
    private DateSerializer dateSerializer;
    GsonBuilder gsonBuilder = new GsonBuilder();

    public ForecastController() {
        
    }

    @GET
    @Path("/observation/{country}/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getObservation(@PathParam("country") String country, @PathParam("city") String city) throws Exception {
        gsonBuilder.registerTypeAdapter(DateTime.class, dateSerializer);
        Gson gson = gsonBuilder.create();
        String json = gson.toJson(service.getCurrentObservation(country, city));
        String out = "{\"Observation\":" + json + "}";
        return out;

    }

    @GET
    @Path("/forecast/{country}/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getForecast(@PathParam("country") String country, @PathParam("city") String city) throws Exception {
        gsonBuilder.registerTypeAdapter(DateTime.class, dateSerializer);
        Gson gson = gsonBuilder.create();
        String json = gson.toJson(service.getForecast(country, city));
        String out = "{\"Forecast\":" + json + "}";
        return out;
    }
}
