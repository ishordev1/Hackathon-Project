package com.techtraveller.Service;

import com.techtraveller.Dto.BookRoomDto;
import java.util.List;

public interface BookRoomService {

    BookRoomDto createBooking(BookRoomDto bookingDto, String roomId, String userId);

    BookRoomDto updateBookingStatus(String bookingId, String status);

    BookRoomDto getBookingById(String bookingId);

    List<BookRoomDto> getBookingsByUser(String userId);

    List<BookRoomDto> getBookingsByRoom(String roomId);

    List<BookRoomDto> getAllBookings();

    void deleteBooking(String bookingId);
}
