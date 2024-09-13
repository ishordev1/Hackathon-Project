package com.techtraveller.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String roomName;
    private String roomType;
    private Double pricePerNight;
    private String description;
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "room_provider_id")
    @JsonBackReference("roomProvider")
    private RoomProvider roomProvider;
    
    
}
