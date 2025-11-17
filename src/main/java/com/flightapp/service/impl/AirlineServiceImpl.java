package com.flightapp.service.impl;

import com.flightapp.dto.AirlineRequest;
import com.flightapp.model.Airline;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.service.AirlineService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirlineServiceImpl implements AirlineService {

    private final AirlineRepository airlineRepository;

    @Override
    public Airline addAirline(AirlineRequest request) {

        Airline airline = Airline.builder()
                .airlineId(request.getAirlineId())
                .airlineName(request.getAirlineName())
                .airlineLogoUrl(request.getAirlineLogoUrl())
                .build();

        return airlineRepository.save(airline);
    }
}
