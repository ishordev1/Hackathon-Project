package com.techtraveller.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "tour_guides")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourGuide {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;
    private String city;
    
    @Enumerated(EnumType.STRING)
    private IdProof idProof;
    

    private String isApproval;
    
    private Date createdDate;
    private String experience;

    private String description;

    private double pricePerDay;

    private double rating = 0.0;
    private String language;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus = AvailabilityStatus.AVAILABLE;
    
    
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; 
 
    

    @OneToMany(mappedBy = "tourGuide",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("tour_Guide")
    private List<TourPackage> tourPackages;
    
//    
    @OneToMany(mappedBy = "tourGuide", cascade = CascadeType.ALL)
    @JsonManagedReference("tourist_guide_book")
	private List<BookTourGuidePackage> bookTourGuidePackage;
     
    public enum AvailabilityStatus {
        AVAILABLE,
        ON_HOLIDAY,
        CREATED_PACKAGE,
        BOOKED
    }


}

