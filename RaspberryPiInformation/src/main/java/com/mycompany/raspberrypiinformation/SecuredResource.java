/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.raspberrypiinformation;

import domain.User;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Elly Goossenaerts
 */
@Path("secure")
public class SecuredResource {
   
    @GET
    @RolesAllowed({"USER"})
    public String getUsername(@Context SecurityContext securityContext) {
        User user = (User)securityContext.getUserPrincipal();
        return user.getName();
    }
}
