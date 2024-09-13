package com.techtraveller.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.techtraveller.Entity.RoomProvider;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalRoomDto {
    private String id;
    private String roomName;
    private String roomType;
    private Double pricePerNight;
    private String description;
    private Boolean isAvailable;

    private RoomProviderDto roomProviderDto;
}
