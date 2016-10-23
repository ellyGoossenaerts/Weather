package view;

import controller.Controller;

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
