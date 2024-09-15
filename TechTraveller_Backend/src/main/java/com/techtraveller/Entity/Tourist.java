package com.techtraveller.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "touristBookedBackages",
        joinColumns = @JoinColumn(name = "tourist_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "book_package_id", 
        referencedColumnName = "bookingPackageId")
    )

    private List<BookTourGuidePackage> bookedPackages;
}

