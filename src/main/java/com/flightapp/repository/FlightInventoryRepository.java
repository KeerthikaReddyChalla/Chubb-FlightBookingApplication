package com.flightapp.repository;

import com.flightapp.model.FlightInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightInventoryRepository extends JpaRepository<FlightInventory, Long> {
    FlightInventory findByFlightNumber(String flightNumber);
}
