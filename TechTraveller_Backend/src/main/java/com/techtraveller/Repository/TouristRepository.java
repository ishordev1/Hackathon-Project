package com.techtraveller.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techtraveller.Entity.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, String> {
    @Query("SELECT t FROM Tourist t JOIN t.bookedPackages b WHERE b.bookingPackageId = :bookingPackageId")
    List<Tourist> findTouristsByBookingPackageId(@Param("bookingPackageId") String bookingPackageId);
}
