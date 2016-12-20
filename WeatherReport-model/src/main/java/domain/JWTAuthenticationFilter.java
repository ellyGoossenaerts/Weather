/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.IOException;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Elly Goossenaerts
 */

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JWTAuthenticationFilter implements ContainerRequestFilter {
    
    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        SecurityContext originalContext = crc.getSecurityContext();
        Set<String> roles = new HashSet<>();
        roles.add("USER");
        Authorizer authorizer = new Authorizer(roles, "user", originalContext.isSecure());
        crc.setSecurityContext(authorizer);
    }

    
}
