/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.raspberrypiinformation;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Eline
 */
@Path("temp")
public class TemperatureController1 {

    @Context
    private UriInfo context;

    RaspberryPiGather service;
    /**
     * Creates a new instance of GenericResource_1
     */
    public TemperatureController1() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.raspberrypiinformation.GenericResource_1
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getTemp")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTemp() throws Exception {
       Gson gson = new Gson();
       String json = gson.toJson(service.gatherFrom().getTemp());
       return json;
    }
    
    @GET
    @Path("/getHumidity")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHumidity(@PathParam("humidity") String humidity) throws Exception {
       Gson gson = new Gson();
       String json = gson.toJson(service.gatherFrom().getHumidity());
       return json;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource_1
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
