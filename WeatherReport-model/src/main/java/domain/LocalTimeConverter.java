/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Eline
 */
import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

    @Override
    public Time convertToDatabaseColumn(LocalTime time) {
        Instant instant = Instant.from(time);
        return (Time) Time.from(instant);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time value) {
        Instant instant = value.toInstant();
        return LocalTime.from(instant);
    }
}
