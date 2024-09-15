package com.techtraveller.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtraveller.Entity.BookTourGuidePackage;
import com.techtraveller.Entity.Tourist;

public interface BookTourGuidePackageRepository extends JpaRepository<BookTourGuidePackage, String> {
List<BookTourGuidePackage> findByTourPackageTourPackageId(String tourPackageId);

}
