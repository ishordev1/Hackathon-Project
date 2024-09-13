package com.techtraveller.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tourists")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    private String phoneNumber;
    private String email;

    private String gender;

    private String address;

    private String nationality;

//    @OneToMany(mappedBy = "tourist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<BookTourGuide> bookings;
    
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookingTourGuidePackage_id")
	private BookTourGuidePackage bookingTourGuidePackage;
}

