/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Eline
 */
public class RegisterFilter {
    
    public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new HashSet<>();
    resources.add(WeatherReport.class); 
    resources.add(AuthenticationFilter.class);
    return resources;
}
}
