/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.WeatherReport;
import java.util.ArrayList;
import java.util.Date;
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
    
    public WeatherReport get(long id){
        Query query = manager.createQuery("select w from Weather w where w.id = :id").setParameter("id", id);
        return (WeatherReport) query.getResultList().get(0);
    }
    
    public List<WeatherReport> getAll(){
        Query query = manager.createQuery("select w from Weather w");
        return  query.getResultList();
    }
    
    public List<WeatherReport> getAllWeatherReportsBefore(Date date){
        Query query = manager.createQuery("select w from Weahter w where w.date < :date").setParameter("date", date);
        return query.getResultList();
    }
    
    public List<WeatherReport> getAllWeatherReportsAfter(Date date){
        Query query = manager.createQuery("select w from Weahter w where w.date > :date").setParameter("date", date);
        return query.getResultList();
    }
    
    public void deleteWeatherReport(WeatherReport report){
            manager.getTransaction().begin();
            WeatherReport reportToBeRemoved = manager.getReference(WeatherReport.class, report.getId());
            manager.remove(reportToBeRemoved);
            manager.getTransaction().commit();
    }
    
    
}
