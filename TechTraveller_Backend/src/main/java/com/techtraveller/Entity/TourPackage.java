package com.techtraveller.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tour_packages")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String tourPackageId;

    @NotBlank(message="package name not empty")
    private String packageName;

//    @NotBlank(message="destination is not empty")
    private String destination;
//    @NotBlank(message="duration Day can't be empty")
    private int durationDays;

//    @NotBlank(message="pricePerPerson can't be empty")
    private double pricePerPerson;
//    @NotBlank(message="pricePerPerson can't be empty")
    private Date startDate;

//    @NotBlank(message="endDate can't be empty")
    private Date endDate;

    private String description;

//    @NotBlank(message="pickupLocation can't be empty")
    private String pickupLocation;

//    @NotBlank(message="numberOfSeats can't be empty")
    private int numberOfSeats;
//    @NotBlank(message="language can't be empty")
    private String language;

    private String transportationMode;
    private String activities;
   
    
    @ManyToOne
    @JoinColumn(name = "tour_guide_id")
    @JsonBackReference("tour_Guide")
    private TourGuide tourGuide;

	@OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL)
	@JsonManagedReference("tour_package")
	List<BookTourGuidePackage> listBookTourGuidePackage = new ArrayList<>();
//    
   
    // Getters and setters
}
