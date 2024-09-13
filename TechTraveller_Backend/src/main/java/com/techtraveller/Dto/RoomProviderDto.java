package com.techtraveller.Dto;

import java.util.List;

import com.techtraveller.Entity.LocalRoom;
import com.techtraveller.Entity.RoomProvider;
import com.techtraveller.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomProviderDto {
    private String id;
    private String name;
    private String contactNumber;
    private String email;
    private String address;
    private String description;
    private double rating;
    private String isVerified;
    
    private UserDto user;
    private List<LocalRoomDto> roomProviderDto;
}
