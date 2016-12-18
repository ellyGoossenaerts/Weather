/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.raspberrypiinformation;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 *
 * @author Elly Goossenaerts
 */

@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {
    
 public AppConfig(){
     packages("packages.to.scan");
     register(RolesAllowedDynamicFeature.class);
 }   
}
