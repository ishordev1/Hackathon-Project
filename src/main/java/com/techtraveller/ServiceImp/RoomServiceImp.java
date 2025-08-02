package com.techtraveller.ServiceImp;

import com.techtraveller.Dto.RoomDto;
import com.techtraveller.Entity.Room;
import com.techtraveller.Entity.User;
import com.techtraveller.Exception.ResourceNotFoundException;
import com.techtraveller.Repository.RoomRepository;
import com.techtraveller.Repository.UserRepository;
import com.techtraveller.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImp implements RoomService {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public RoomDto createRoom(RoomDto roomDto, String ownerId) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found"));
        Room room = modelMapper.map(roomDto, Room.class);
        room.setOwner(owner);
        Room savedRoom = roomRepository.save(room);
        return modelMapper.map(savedRoom, RoomDto.class);
    }

    @Override
    public RoomDto updateRoom(String roomId, RoomDto roomDto) {
        Room existingRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        modelMapper.map(roomDto, existingRoom);
        Room updatedRoom = roomRepository.save(existingRoom);
        return modelMapper.map(updatedRoom, RoomDto.class);
    }

    @Override
    public RoomDto getRoomById(String roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(room -> modelMapper.map(room, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> getRoomsByOwner(String ownerId) {
        List<Room> rooms = roomRepository.findByOwnerUserId(ownerId);
        return rooms.stream()
                .map(room -> modelMapper.map(room, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRoom(String roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        roomRepository.delete(room);
    }
}
