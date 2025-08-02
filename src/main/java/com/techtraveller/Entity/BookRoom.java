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
public class BookRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDateTime;

    private Long durationInMinutes;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingType bookingType; // HOURLY or NIGHTLY

    private String status; // PENDING, ACCEPTED, REJECTED, ONGOING, COMPLETED, CANCELLED

    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingCreatedAt;

    public enum BookingType {
        HOURLY, NIGHTLY
    }
}
