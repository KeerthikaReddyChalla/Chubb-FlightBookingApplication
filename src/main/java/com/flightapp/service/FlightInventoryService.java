package com.flightapp.service;

import java.util.*;
import com.flightapp.dto.InventoryRequest;
import com.flightapp.model.FlightInventory;

public interface FlightInventoryService {
    FlightInventory addInventory(InventoryRequest request);
    List<FlightInventory> searchFlights(String origin, String destination, String date);

}
