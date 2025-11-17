package com.flightapp.service.impl;

import com.flightapp.dto.InventoryRequest;
import com.flightapp.model.Airline;
import com.flightapp.model.FlightInventory;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.FlightInventoryRepository;
import com.flightapp.service.FlightInventoryService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class FlightInventoryServiceImpl implements FlightInventoryService {

    private final FlightInventoryRepository inventoryRepo;
    private final AirlineRepository airlineRepo;

    public FlightInventoryServiceImpl(FlightInventoryRepository inventoryRepo,
                                      AirlineRepository airlineRepo) {
        this.inventoryRepo = Objects.requireNonNull(inventoryRepo, "inventoryRepo");
        this.airlineRepo = Objects.requireNonNull(airlineRepo, "airlineRepo");
    }

    @Override
    public FlightInventory addInventory(InventoryRequest req) {

        if (req == null) {
            throw new IllegalArgumentException("InventoryRequest is null");
        }
        if (req.getAirlineId() == null || req.getAirlineId().isBlank()) {
            throw new IllegalArgumentException("airlineId is required");
        }

        Airline airline = airlineRepo.findByAirlineId(req.getAirlineId());
        if (airline == null) {
            throw new EntityNotFoundException("Airline does not exist: " + req.getAirlineId());
        }

        FlightInventory inv = FlightInventory.builder()
                .flightNumber(req.getFlightNumber())
                .airlineId(req.getAirlineId())
                .airlineName(airline.getAirlineName())
                .origin(req.getOrigin())
                .destination(req.getDestination())
                .price(req.getPrice() == null ? 0.0 : req.getPrice())
                .totalSeats(req.getTotalSeats() == null ? 0 : req.getTotalSeats())
                .availableSeats(req.getTotalSeats() == null ? 0 : req.getTotalSeats())
                .departureDate(req.getDepartureDate() != null ? req.getDepartureDate() : LocalDateTime.now().plusDays(1))
                .build();

        return inventoryRepo.save(inv);
    }
}
