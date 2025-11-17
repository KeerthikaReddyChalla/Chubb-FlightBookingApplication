package com.flightapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "airline")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Airline ID cannot be empty")
    @Column(unique = true, nullable = false)
    private String airlineId;

    @NotBlank(message = "Airline name cannot be empty")
    private String airlineName;

    private String airlineLogoUrl; 
}
