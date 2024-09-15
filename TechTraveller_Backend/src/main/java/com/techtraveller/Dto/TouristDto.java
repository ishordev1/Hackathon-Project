package com.techtraveller.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techtraveller.Entity.BookTourGuidePackage;
import com.techtraveller.Entity.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TouristDto {

    private String id;
    private String name;
    private User user;
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;
    private String nationality;
    private List<BookTourGuidePackageDto> bookedPackages;
//    private List<BookTourGuideDto> bookings;
}
