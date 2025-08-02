package com.techtraveller.Dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RoomDto {

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
    private String ownerId;
}