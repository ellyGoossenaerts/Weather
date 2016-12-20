/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.security.Principal;

/**
 *
 * @author Elly Goossenaerts
 */
public class User implements Principal {
    
    private String username;
    
    public User(String username){
        this.username = username;
    }

    @Override
    public String getName() {
        return username;
    }
    
}
