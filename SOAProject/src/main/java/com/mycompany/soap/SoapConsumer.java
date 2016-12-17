/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soap;

/**
 *
 * @author Eline
 */
public class SoapConsumer {
    
    public static void main(String[] args){
        System.out.println(new TestServiceService().getTestServicePort().duplicator("hello", "world"));
    }
    
}
