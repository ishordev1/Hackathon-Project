package com.techtraveller.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtraveller.Dto.RoomProviderDto;
import com.techtraveller.Dto.UserDto;
import com.techtraveller.Entity.RoomProvider;
import com.techtraveller.Entity.User;
import com.techtraveller.Exception.ResourceNotFoundException;
import com.techtraveller.Repository.RoomProviderRepository;
import com.techtraveller.Repository.UserRepository;
import com.techtraveller.Service.RoomProviderService;
import com.techtraveller.Service.UserService;

@Service
public class RoomProviderServiceImp implements RoomProviderService {

    @Autowired
    private RoomProviderRepository roomProviderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;
    
    @Override
    public RoomProviderDto createRoomProvider(RoomProviderDto roomProviderDto) {
    	UserDto userDto=roomProviderDto.getUser();
    UserDto saveUser = this.userService.createUser(userDto);
        RoomProvider roomProvider = modelMapper.map(roomProviderDto, RoomProvider.class);
        roomProvider.setEmail(saveUser.getEmail());
        roomProvider.setUser(this.modelMapper.map(saveUser, User.class));
        roomProvider.setIsVerified("PENDING");
        RoomProvider savedRoomProvider = roomProviderRepository.save(roomProvider);
        RoomProviderDto map = this.modelMapper.map(savedRoomProvider, RoomProviderDto.class);
        return  map;
    }

    @Override
    public RoomProviderDto updateRoomProvider(String id, RoomProviderDto roomProviderDto) {
        RoomProvider roomProvider = roomProviderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room Provider not found with id: " + id));
        
        modelMapper.map(roomProviderDto, roomProvider);
        RoomProvider updatedRoomProvider = roomProviderRepository.save(roomProvider);
        return modelMapper.map(updatedRoomProvider, RoomProviderDto.class);
    }

    @Override
    public RoomProviderDto getRoomProviderById(String id) {
        RoomProvider roomProvider = roomProviderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room Provider not found with id: " + id));
        
        return modelMapper.map(roomProvider, RoomProviderDto.class);
    }

    @Override
    public List<RoomProviderDto> getAllRoomProviders() {
        return roomProviderRepository.findAll().stream()
                .map(provider -> modelMapper.map(provider, RoomProviderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRoomProvider(String id) {
        if (!roomProviderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Room Provider not found with id: " + id);
        }
        roomProviderRepository.deleteById(id);
    }
}