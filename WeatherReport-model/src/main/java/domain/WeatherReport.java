/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eline
 */
@Entity
@Table(name="weatherReport")
public class WeatherReport {
    
    @Id @GeneratedValue(strategy=AUTO) @Column(name="weatherReport_id", nullable=false)
    private long id;
    @Column(name="temperature",nullable=false)
    private double temp;
    @Column(name="humidity",nullable=false)
    private String humidity;
    @Column(name="date",nullable=false)
    private LocalDate date;
    @Column(name="time",nullable=false)
    private LocalTime time;

    public WeatherReport() {
    }

    public WeatherReport(double temp, String humidity, LocalDate dateToday, LocalTime timeToday) {
        this.temp = temp;
        this.humidity = humidity;
        this.time = timeToday;
        this.date = dateToday;
    }

    public String getHumidity() {
        return humidity;
    }

    public double getTemp() {
        return temp;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    
    
    
    
    
}
