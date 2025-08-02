package com.techtraveller.Service;

import com.techtraveller.Dto.BookVehicleDto;
import java.util.List;

public interface BookVehicleService {

    BookVehicleDto createBooking(BookVehicleDto bookingDto, String vehicleId, String userId);

    BookVehicleDto updateBookingStatus(String bookingId, String status);

    BookVehicleDto getBookingById(String bookingId);

    List<BookVehicleDto> getBookingsByUser(String userId);

    List<BookVehicleDto> getBookingsByVehicle(String vehicleId);

    List<BookVehicleDto> getAllBookings();

    void deleteBooking(String bookingId);
}
