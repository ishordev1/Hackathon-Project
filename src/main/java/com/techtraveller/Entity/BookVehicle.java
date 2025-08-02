package com.techtraveller.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDateTime;

    private Long durationInMinutes; 

    private Double totalPrice;

    private String status; // PENDING, ACCEPTED, REJECTED, ONGOING, COMPLETED, CANCELLED

    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingCreatedAt;
}
