package com.flightapp.service;

import com.flightapp.dto.AirlineRequest;
import com.flightapp.model.Airline;


public interface AirlineService {
    Airline addAirline(AirlineRequest request);

	
}
