package com.flightapp.controller;

import com.flightapp.dto.InventoryRequest;
import com.flightapp.model.FlightInventory;
import com.flightapp.service.FlightInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/flight/inventory")
@RequiredArgsConstructor
public class FlightInventoryController {

    private final FlightInventoryService inventoryService;

    @PostMapping("/add")
    public FlightInventory add(@RequestBody InventoryRequest req) {
        return inventoryService.addInventory(req);
    }
}
