package com.techtraveller.Dto;

import lombok.*;
import java.util.Date;

import com.techtraveller.Entity.User;
import com.techtraveller.Entity.Vehicle;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookVehicleDto {
	 private String bookingId;

	    private VehicleDto vehicle;
	    private UserDto user;
	    private Date startDateTime;
	    private Date endDateTime;
	    private Long durationInMinutes; 
	    private Double totalPrice;
	    private String status; // PENDING, ACCEPTED, REJECTED, ONGOING, COMPLETED, CANCELLED
	    private Date bookingCreatedAt;
}
