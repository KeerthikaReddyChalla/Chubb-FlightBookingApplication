package com.flightapp.service;

import com.flightapp.dto.BookingRequest;
import com.flightapp.model.Booking;

import java.util.List;

public interface BookingService {
    Booking bookTicket(BookingRequest request);
    Booking getByPnr(String pnr);
    List<Booking> getHistory(String email);
    String cancel(String pnr);
}
