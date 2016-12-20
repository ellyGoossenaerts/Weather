/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaserverfaces;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
        

/**
 *
 * @author Eline
 */
@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    	private String firstName;
        private String lastName;

	public String getFirstName() {
		return firstName;
	}
	public void setfirstName(String name) {
		this.firstName = name;
	}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
        
        
    
}
