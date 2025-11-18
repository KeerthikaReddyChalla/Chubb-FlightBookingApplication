package com.flightapp.controller;

import com.flightapp.dto.InventoryRequest;
import java.util.*;
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
    @PostMapping("/search")
    public List<FlightInventory> search(@RequestBody Map<String, String> req) {
        String origin = req.get("origin");
        String destination = req.get("destination");
        String date = req.get("date");

        return inventoryService.searchFlights(origin, destination, date);
    }

}
