package com.mycompany.weatherforecast.restapi;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import org.joda.time.DateTime;

/**
 *
 * @author Elly Goossenaerts
 */
public class DateSerializer implements JsonSerializer<DateTime> {
    
    public DateSerializer(){
        
    }
        
    public JsonElement serialize(DateTime date, Type typeOfSrc, JsonSerializationContext context){
        return new JsonPrimitive(date.toString("dd/MM/yyyy"));
    }
    
}
