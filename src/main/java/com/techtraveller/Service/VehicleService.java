package com.techtraveller.Service;

import com.techtraveller.Dto.VehicleDto;
import java.util.List;

public interface VehicleService {

    VehicleDto createVehicle(VehicleDto vehicleDto, String ownerId);

    VehicleDto updateVehicle(String id, VehicleDto vehicleDto);

    VehicleDto getVehicleById(String id);

    List<VehicleDto> getAllVehicles();

    void deleteVehicle(String id);

    List<VehicleDto> getVehiclesByOwner(String ownerId);
}
