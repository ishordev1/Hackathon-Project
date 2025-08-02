package com.techtraveller.Repository;

import com.techtraveller.Entity.BookRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BookRoomRepository extends JpaRepository<BookRoom, String> {

	
	 // Check if any ACCEPTED booking exists in the selected slot
    @Query("SELECT b FROM BookRoom b WHERE b.room.roomId = :roomId AND b.status = 'ACCEPTED' " +
           "AND ((b.checkInDateTime < :endDateTime AND b.checkOutDateTime > :startDateTime))")
    List<BookRoom> findOverlappingAcceptedBookings(String roomId, Date startDateTime, Date endDateTime);

    // Find overlapping pending bookings for cancellation when one is accepted
    @Query("SELECT b FROM BookRoom b WHERE b.room.roomId = :roomId AND b.status = 'PENDING' " +
           "AND ((b.checkInDateTime < :endDateTime AND b.checkOutDateTime > :startDateTime))")
    List<BookRoom> findOverlappingPendingBookings(String roomId, Date startDateTime, Date endDateTime);

    List<BookRoom> findByUserUserId(String userId);

    List<BookRoom> findByRoomRoomId(String roomId);
}

