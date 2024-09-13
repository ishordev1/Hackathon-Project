package com.techtraveller.ServiceImp;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtraveller.Dto.LocalRoomDto;
import com.techtraveller.Entity.LocalRoom;
import com.techtraveller.Entity.RoomProvider;
import com.techtraveller.Exception.ResourceNotFoundException;
import com.techtraveller.Repository.LocalRoomRepository;
import com.techtraveller.Repository.RoomProviderRepository;
import com.techtraveller.Service.LocalRoomService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocalRoomServiceImp implements LocalRoomService {

    @Autowired
    private LocalRoomRepository localRoomRepository;

    @Autowired
    private RoomProviderRepository roomProviderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LocalRoomDto createLocalRoom(LocalRoomDto localRoomDto, String roomProviderId) {
 
        RoomProvider roomProvider = roomProviderRepository.findById(roomProviderId)
                .orElseThrow(() -> new ResourceNotFoundException("Room Provider not found with id: " + roomProviderId));

        LocalRoom localRoom = modelMapper.map(localRoomDto, LocalRoom.class);
        localRoom.setRoomProvider(roomProvider);
        System.out.println("this is provider id:"+localRoom.getRoomProvider().getId());
        
        LocalRoom savedLocalRoom = localRoomRepository.save(localRoom);
        return modelMapper.map(savedLocalRoom, LocalRoomDto.class);
    }

    @Override
    public LocalRoomDto updateLocalRoom(LocalRoomDto localRoomDto, String localRoomId, String roomProviderId) {
        LocalRoom localRoom = localRoomRepository.findById(localRoomId)
                .orElseThrow(() -> new ResourceNotFoundException("Local Room not found with id: " + localRoomId));

        RoomProvider roomProvider = roomProviderRepository.findById(roomProviderId)
                .orElseThrow(() -> new ResourceNotFoundException("Room Provider not found with id: " + roomProviderId));

        modelMapper.map(localRoomDto, localRoom);
        localRoom.setRoomProvider(roomProvider);
        LocalRoom updatedLocalRoom = localRoomRepository.save(localRoom);
        return modelMapper.map(updatedLocalRoom, LocalRoomDto.class);
    }

    @Override
    public LocalRoomDto getLocalRoomById(String id) {
        LocalRoom localRoom = localRoomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Local Room not found with id: " + id));

        return modelMapper.map(localRoom, LocalRoomDto.class);
    }

    @Override
    public List<LocalRoomDto> getAllLocalRooms() {
        return localRoomRepository.findAll().stream()
                .map(room -> modelMapper.map(room, LocalRoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LocalRoomDto> getAllLocalRoomsRoomProviderId(String roomProviderId) {
        RoomProvider roomProvider = roomProviderRepository.findById(roomProviderId)
                .orElseThrow(() -> new ResourceNotFoundException("Room Provider not found with id: " + roomProviderId));

        return localRoomRepository.findAll().stream()
                .filter(room -> room.getRoomProvider().equals(roomProvider))
                .map(room -> modelMapper.map(room, LocalRoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLocalRoom(String id) {
        if (!localRoomRepository.existsById(id)) {
            throw new ResourceNotFoundException("Local Room not found with id: " + id);
        }
        localRoomRepository.deleteById(id);
    }
}