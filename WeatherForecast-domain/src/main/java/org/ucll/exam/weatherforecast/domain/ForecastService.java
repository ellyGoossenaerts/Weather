package org.ucll.exam.weatherforecast.domain;

import db.ForecastDatabase;
import db.ObservationDatabase;


public class ForecastService {

    private final ForecastDatabase forecastDb;
    private final ObservationDatabase observationDb;
    private final ForecastGatherer forecastGatherer;
    

    public ForecastService() {
        forecastDb = new ForecastDatabase();
        observationDb = new ObservationDatabase();
        forecastGatherer = new ForecastGatherer();
    }

    public Observation getCurrentObservation(Observation location) throws Exception{
        return forecastGatherer.getCurrentObservation(location);
    }

    
}
