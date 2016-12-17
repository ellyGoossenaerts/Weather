/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.WeatherReport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Eline
 */
public class WeatherReportDB {
    
    private EntityManager manager;
    private EntityManagerFactory factory;
    public WeatherReportDB(String name){
        factory = Persistence.createEntityManagerFactory(name);
        manager = factory.createEntityManager();
    }
    
    public void closeConnection(){
        manager.close();
        factory.close();
    }
    
    public void add(WeatherReport object){
        manager.getTransaction().begin();
        manager.persist(object);
        manager.flush();
        manager.getTransaction().commit();
        
    }
    
    public List<WeatherReport> getAll(){
        Query query = manager.createQuery("select w from Weather w");
        return  query.getResultList();
    }
    
    
}
