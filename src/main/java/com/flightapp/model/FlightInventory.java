package com.flightapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String flightNumber;
    
    private String airlineId;
    
    private String airlineName;

    private String origin;

    private String destination;

    private Double price;

    private Integer totalSeats;

    private Integer availableSeats;

    private LocalDateTime departureDate;
}
