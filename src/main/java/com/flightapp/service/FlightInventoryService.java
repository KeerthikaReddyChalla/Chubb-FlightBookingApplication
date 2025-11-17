package com.flightapp.service;

import com.flightapp.dto.InventoryRequest;
import com.flightapp.model.FlightInventory;

public interface FlightInventoryService {
    FlightInventory addInventory(InventoryRequest request);
}
