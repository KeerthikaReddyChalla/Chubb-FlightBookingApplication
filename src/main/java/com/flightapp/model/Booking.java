package com.flightapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pnr;

    private String email;

    @ManyToOne
    private FlightInventory flightInventory;

    private Integer seats;

    private String mealType;

    private Double totalAmount;

    private LocalDateTime bookingDate;

    private boolean isCancelled;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Passenger> passengers;
}
