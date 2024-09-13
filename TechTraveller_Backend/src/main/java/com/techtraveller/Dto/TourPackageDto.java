package com.techtraveller.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.techtraveller.Entity.TourGuide;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TourPackageDto {

	private String tourPackageId;
    private String packageName;
    private String destination;
    private int durationDays;
    private double pricePerPerson;
    private Date startDate;
    private Date endDate;
    private String description;
    private String pickupLocation;
    private int numberOfSeats;
 
    private String language;
    private String transportationMode;
    private String activities;
    
    private String tourGuideId;
}
