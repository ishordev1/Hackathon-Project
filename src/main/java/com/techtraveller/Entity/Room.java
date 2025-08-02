package com.techtraveller.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String roomId;

    private String name;
    private String type;
    private String description;
    private Double pricePerNight;
    private Double pricePerHour;
    private Boolean isActive = true;
    private Integer capacity;
    private String imageUrl;
    private String location;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
