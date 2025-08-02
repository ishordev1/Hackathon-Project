package com.techtraveller.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtraveller.Entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String>{
List<Vehicle> findByOwnerUserId(String ownerId);
}
