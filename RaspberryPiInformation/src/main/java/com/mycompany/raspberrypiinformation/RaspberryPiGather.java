/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.raspberrypiinformation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Eline
 */
public class RaspberryPiGather {
    
    private String url = "/projects/readDHT22.py";
    Map<String,Object> temperature = new HashMap();

    public RaspberryPiGather() {
    }
    
    public Temperature gatherFrom() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url).resolveTemplates(this.temperature);
        ObjectMapper objectMapper = new ObjectMapper();
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        Temperature t = null;
        try {
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode temp = rootNode.path("temp");
            JsonNode humidity = rootNode.path("humidity");
            t = new Temperature(temp.doubleValue(),humidity.textValue());
        } catch (Exception e) {
        }
        return t;
    }  
    
    
}
    

