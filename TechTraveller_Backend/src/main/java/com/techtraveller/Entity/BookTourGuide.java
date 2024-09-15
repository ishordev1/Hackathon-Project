package com.techtraveller.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookTourGuide {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(nullable = false)
    private double totalCost;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status;

    @Column
    private String notes;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    
    @ManyToOne
    @JoinColumn(name = "tour_guide_id", nullable = false)
    private TourGuide tourGuide;
    
  
    @ManyToOne
    @JoinColumn(name = "tourist_id", nullable = false)
    private Tourist tourist;
    
    
    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELLED,
        COMPLETED
    }


}

