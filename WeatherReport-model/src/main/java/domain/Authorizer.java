/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.security.Principal;
import java.util.Set;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Elly Goossenaerts
 */
public class Authorizer implements SecurityContext{

    Set<String> roles;
    String username;
    boolean isSecure;
    
    public Authorizer(Set<String> roles, final String username, boolean isSecure){
        this.roles = roles;
        roles.add("USER");
        this.username = username;
        this.isSecure = isSecure;
    }
    
    @Override
    public Principal getUserPrincipal() {
        return new User(username);
    }

    @Override
    public boolean isUserInRole(String role) {
        return roles.contains(role);
    }

    @Override
    public boolean isSecure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAuthenticationScheme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
