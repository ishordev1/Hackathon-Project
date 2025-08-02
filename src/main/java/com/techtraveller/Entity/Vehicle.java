package com.techtraveller.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vehicleId;

    private String name;
    private String type;
    private String model;
    private String registrationNumber;
    private String color;

    private Integer seatingCapacity;
    private String fuelType;
    private String transmissionType;
    private Boolean isActive = true;
    private Double pricePerHour;
    private String pickupAddress;

    private String description;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
