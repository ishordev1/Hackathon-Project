package com.techtraveller.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtraveller.Entity.TourGuide;
import com.techtraveller.Entity.TourPackage;

public interface TourPackageRepository extends JpaRepository<TourPackage, String>{
List<TourPackage> findByTourGuideId(String id);
}
