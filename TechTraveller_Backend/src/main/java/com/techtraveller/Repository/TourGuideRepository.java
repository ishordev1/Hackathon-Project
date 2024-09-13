package com.techtraveller.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtraveller.Entity.TourGuide;

public interface TourGuideRepository extends JpaRepository<TourGuide, String>{
Optional<TourGuide> findByEmail(String email);
}
