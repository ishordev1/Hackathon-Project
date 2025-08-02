package com.techtraveller.Controller;

import com.techtraveller.Dto.BookVehicleDto;
import com.techtraveller.Service.BookVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookVehicleController {

    private final BookVehicleService bookingService;

    // Create a new booking
    @PostMapping("/{vehicleId}/user/{userId}")
    public ResponseEntity<BookVehicleDto> createBooking(
            @PathVariable String vehicleId,
            @PathVariable String userId,
            @RequestBody BookVehicleDto bookingDto) {
        BookVehicleDto createdBooking = bookingService.createBooking(bookingDto, vehicleId, userId);
        return ResponseEntity.ok(createdBooking);
    }

    // Update booking status (ACCEPTED, REJECTED, CANCELLED, etc.)
    @PutMapping("/{bookingId}/status")
    public ResponseEntity<BookVehicleDto> updateBookingStatus(
            @PathVariable String bookingId,
            @RequestParam String status) {
        BookVehicleDto updatedBooking = bookingService.updateBookingStatus(bookingId, status);
        return ResponseEntity.ok(updatedBooking);
    }

    // Get booking by ID
    @GetMapping("/{bookingId}")
    public ResponseEntity<BookVehicleDto> getBookingById(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));
    }

    // Get all bookings by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookVehicleDto>> getBookingsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
    }

    // Get all bookings by vehicle
    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<BookVehicleDto>> getBookingsByVehicle(@PathVariable String vehicleId) {
        return ResponseEntity.ok(bookingService.getBookingsByVehicle(vehicleId));
    }

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<BookVehicleDto>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // Delete booking
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable String bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
}
