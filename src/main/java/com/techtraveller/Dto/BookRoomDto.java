package com.techtraveller.Dto;

import java.util.Date;

import com.techtraveller.Entity.Room;
import com.techtraveller.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.techtraveller.Entity.BookRoom.BookingType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRoomDto {
	  private String bookingId;

	    private Room room;

	    private User user;

	    private Date checkInDateTime;

	    private Date checkOutDateTime;

	    private Long durationInMinutes;

	    private Double totalPrice;

	    private BookingType bookingType; // HOURLY or NIGHTLY

	    private String status; // PENDING, ACCEPTED, REJECTED, ONGOING, COMPLETED, CANCELLED

	    private Date bookingCreatedAt;

}
