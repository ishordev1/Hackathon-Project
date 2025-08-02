package com.techtraveller.Dto;

import com.techtraveller.Entity.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
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
	    private String pickupAddress;
	    private Double pricePerHour;
	    private String description;
	    private String imageUrl;
	    private String ownerId;
	

}
