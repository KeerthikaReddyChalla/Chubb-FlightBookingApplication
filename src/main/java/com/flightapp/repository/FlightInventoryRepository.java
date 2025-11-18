package com.flightapp.repository;

import com.flightapp.model.FlightInventory;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightInventoryRepository extends JpaRepository<FlightInventory, Long> {
    FlightInventory findByFlightNumber(String flightNumber);
    List<FlightInventory> findByOriginAndDestination(String origin, String destination);

}
