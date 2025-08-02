package com.techtraveller.Repository;

import com.techtraveller.Entity.BookVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BookVehicleRepository extends JpaRepository<BookVehicle, String> {

	@Query("SELECT b FROM BookVehicle b WHERE b.vehicle.vehicleId = :vehicleId " +
		       "AND b.status IN ('ACCEPTED', 'ONGOING') " +
		       "AND (b.startDateTime < :endDateTime AND b.endDateTime > :startDateTime)")
		List<BookVehicle> findOverlappingBookings(String vehicleId, Date startDateTime, Date endDateTime);

	@Query("SELECT b FROM BookVehicle b WHERE b.vehicle.vehicleId = :vehicleId " +
		       "AND b.status = 'PENDING' " +
		       "AND b.bookingId <> :currentBookingId " +
		       "AND (b.startDateTime < :endDateTime AND b.endDateTime > :startDateTime)")
		List<BookVehicle> findPendingBookings(String vehicleId, Date startDateTime, Date endDateTime, String currentBookingId);

    List<BookVehicle> findByUserUserId(String userId);

    List<BookVehicle> findByVehicleVehicleId(String vehicleId);
}
