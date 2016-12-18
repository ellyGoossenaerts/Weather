/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.raspberrypiinformation;

import com.google.gson.Gson;
import domain.Compress;
import domain.RaspberryPiGather;
import domain.WeatherReport;
import domain.WeatherReportService;
import java.lang.annotation.Retention;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.NameBinding;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * REST Web Service
 *
 * @author Eline
 */


@Path("weatherreport")
public class TemperatureController1 {

    @Context
    private UriInfo context;
    
    @Inject
    WeatherReportService service;
    /**
     * Creates a new instance of GenericResource_1
     */
    public TemperatureController1() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.raspberrypiinformation.GenericResource_1
     * @return an instance of java.lang.String
     * @throws java.lang.Exception
     */
    @GET
    //@Path("/getWeatherReport")
    @Produces(MediaType.APPLICATION_JSON)
    @Compress
    public String getWeatherReport() throws Exception {
       Gson gson = new Gson();
       String json = gson.toJson(service.getWeatherReport());
       return json;
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Compress
    public String getAllWeatherReports() throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(service.getAllWeatherReports());
        return json;
    }
    
    @GET
    @Path("/all/before/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    @Compress
    public String getAllWeatherReportsBefore(@PathParam("date") String date) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(service.getAllWeatherReportsBefore(toDate(date)));
        return json;
    }
    
    @GET
    @Path("/all/after/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    @Compress
    public String getAllWeatherReportsAfter(@PathParam("date") String date) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(service.getAllWeatherReportsAfter(toDate(date)));
        return json;
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Compress
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") String id){
        service.deleteWeatherReport(service.get(Long.parseLong(id)));
    }
    
    public Date toDate(String string) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return (Date) dateFormat.parse(string);
    }

}
