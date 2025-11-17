package com.flightapp.service.impl;

import com.flightapp.dto.BookingRequest;
import com.flightapp.model.*;
import com.flightapp.repository.*;
import com.flightapp.repository.BookingRepository;
import com.flightapp.service.BookingService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FlightInventoryRepository inventoryRepo;

    @Override
    public Booking bookTicket(BookingRequest req) {

        FlightInventory inv = inventoryRepo.findByFlightNumber(req.getFlightNumber());
        if (inv == null) {
            throw new EntityNotFoundException("Flight not found: " + req.getFlightNumber());
        }

        if (inv.getAvailableSeats() < req.getSeats()) {
            throw new IllegalStateException("Not enough seats available");
        }

        inv.setAvailableSeats(inv.getAvailableSeats() - req.getSeats());
        inventoryRepo.save(inv);

        List<Passenger> passengers =
                req.getPassengers().stream()
                        .map(p -> Passenger.builder()
                                .name(p.getName())
                                .gender(p.getGender())
                                .age(p.getAge())
                                .build())
                        		.toList(); 

        Booking booking = Booking.builder()
                .pnr(UUID.randomUUID().toString().substring(0, 8).toUpperCase())
                .email(req.getEmail())
                .flightInventory(inv)
                .seats(req.getSeats())
                .mealType(req.getMealType())
                .passengers(passengers)
                .totalAmount(inv.getPrice() * req.getSeats())
                .bookingDate(LocalDateTime.now())
                .isCancelled(false)
                .build();

        return bookingRepo.save(booking);
    }

    @Override
    public Booking getByPnr(String pnr) {
        return bookingRepo.findByPnr(pnr);
    }

    @Override
    public List<Booking> getHistory(String email) {
        return bookingRepo.findByEmail(email);
    }

    @Override
    public String cancel(String pnr) {
        Booking booking = bookingRepo.findByPnr(pnr);
        if (booking == null) return "Invalid PNR";

        FlightInventory inv = booking.getFlightInventory();
        inv.setAvailableSeats(inv.getAvailableSeats() + booking.getSeats());
        inventoryRepo.save(inv);

        booking.setCancelled(true);
        bookingRepo.save(booking);

        return "Cancelled Successfully";
    }
    
    
}
