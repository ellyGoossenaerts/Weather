/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import org.ucll.exam.weatherforecast.domain.Controller;

/**
 *
 * @author Eline
 */
public class UI {
    public static void main(String[] args) {
        Controller c = new Controller();
        InputCountry inputCountry = new InputCountry(c);
    }
    
}
