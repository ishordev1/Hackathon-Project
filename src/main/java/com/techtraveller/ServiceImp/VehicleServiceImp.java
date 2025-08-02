package com.techtraveller.ServiceImp;

import com.techtraveller.Dto.VehicleDto;
import com.techtraveller.Entity.User;
import com.techtraveller.Entity.Vehicle;
import com.techtraveller.Exception.ResourceNotFoundException;
import com.techtraveller.Repository.UserRepository;
import com.techtraveller.Repository.VehicleRepository;
import com.techtraveller.Service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImp implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto, String ownerId) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found"));
        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
        vehicle.setOwner(owner);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return modelMapper.map(savedVehicle, VehicleDto.class);
    }

    @Override
    public VehicleDto updateVehicle(String id, VehicleDto vehicleDto) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        
        modelMapper.map(vehicleDto, existingVehicle);
        
        Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
        return modelMapper.map(updatedVehicle, VehicleDto.class);
    }

    @Override
    public VehicleDto getVehicleById(String id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        return modelMapper.map(vehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVehicle(String id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        vehicleRepository.delete(vehicle);
    }

    @Override
    public List<VehicleDto> getVehiclesByOwner(String ownerId) {
        List<Vehicle> vehicles = vehicleRepository.findByOwnerUserId(ownerId);
        return vehicles.stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }
}
