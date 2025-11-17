package com.flightapp.service;

import com.flightapp.dto.AirlineRequest;
import com.flightapp.model.Airline;

import jakarta.validation.Valid;

public interface AirlineService {
    Airline addAirline(AirlineRequest request);

	
}
