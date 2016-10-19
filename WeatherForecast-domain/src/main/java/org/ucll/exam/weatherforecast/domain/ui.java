/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ucll.exam.weatherforecast.domain;

import java.io.IOException;
import org.apache.tools.ant.Main;

/**
 *
 * @author Eline
 */
public class ui {
    
        public static void main(String[] args) throws IOException, Exception{
            
            ForecastService service = new ForecastService();
            Observation c = new Observation("Leuven","BE");
            //service.getCityForecast(c);
            
            System.out.println(service.getCityForecast(c).getForcasts());
            
        }
    
}
