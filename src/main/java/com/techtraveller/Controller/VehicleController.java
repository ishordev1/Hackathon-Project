package com.techtraveller.Controller;

import com.techtraveller.Dto.VehicleDto;
import com.techtraveller.Service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    // Create Vehicle
    @PostMapping("/{ownerId}")
    public ResponseEntity<VehicleDto> createVehicle(@PathVariable String ownerId, @RequestBody VehicleDto vehicleDto) {
        VehicleDto createdVehicle = vehicleService.createVehicle(vehicleDto, ownerId);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    // Update Vehicle
    @PutMapping("/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable String id, @RequestBody VehicleDto vehicleDto) {
        VehicleDto updatedVehicle = vehicleService.updateVehicle(id, vehicleDto);
        return ResponseEntity.ok(updatedVehicle);
    }

    // Get Vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable String id) {
        VehicleDto vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    // Get All Vehicles
    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        List<VehicleDto> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    // Delete Vehicle
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok("Vehicle deleted successfully");
    }

    // Get Vehicles by Owner
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByOwner(@PathVariable String ownerId) {
        List<VehicleDto> vehicles = vehicleService.getVehiclesByOwner(ownerId);
        return ResponseEntity.ok(vehicles);
    }
}
