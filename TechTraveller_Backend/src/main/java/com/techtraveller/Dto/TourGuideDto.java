package com.techtraveller.Dto;


import com.techtraveller.Entity.TourGuide.AvailabilityStatus;
//import com.techtraveller.Entity.BookTourGuide;
import com.techtraveller.Entity.IdProof;
import com.techtraveller.Entity.Role;
import com.techtraveller.Entity.TourPackage;
import com.techtraveller.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TourGuideDto {

    private String id;

    private String phoneNumber;
    private String gender;
    private String address;
    private String city;
    private String email;
    private String isApproval;
    private IdProof idProof;
    private Date createdDate;
    private String experience;
    private String description;
    private double pricePerDay;
    private double rating;  
   private String language;
   
    private AvailabilityStatus availabilityStatus;
    private UserDto user;
    private List<TourPackageDto> tourPackages;
//    private List<BookTourGuideDto> bookings;
}
