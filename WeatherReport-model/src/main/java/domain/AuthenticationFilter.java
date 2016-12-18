/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Eline
 */
public class AuthenticationFilter implements ContainerRequestFilter {
    
    
    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        final SecurityContext securityContext = crc.getSecurityContext();
        if(securityContext == null || !securityContext.isUserInRole("privileged")){
            crc.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("user cannot acces the resouce.").build());
        }
    }
    

}
