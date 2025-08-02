package com.techtraveller.Controller;

import com.techtraveller.Dto.BookRoomDto;
import com.techtraveller.Service.BookRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/room-bookings")
@RequiredArgsConstructor
public class BookRoomController {

    private final BookRoomService bookRoomService;

    // Create a booking (always saved as PENDING initially)
    @PostMapping("/{roomId}/user/{userId}")
    public ResponseEntity<BookRoomDto> createBooking(
            @PathVariable String roomId,
            @PathVariable String userId,
            @RequestBody BookRoomDto bookingDto) {
        return ResponseEntity.ok(bookRoomService.createBooking(bookingDto, roomId, userId));
    }

    // Update booking status (ACCEPTED, REJECTED, CANCELLED)
    @PutMapping("/{bookingId}/status")
    public ResponseEntity<BookRoomDto> updateBookingStatus(
            @PathVariable String bookingId,
            @RequestParam String status) {
        return ResponseEntity.ok(bookRoomService.updateBookingStatus(bookingId, status));
    }

    // Get a single booking
    @GetMapping("/{bookingId}")
    public ResponseEntity<BookRoomDto> getBookingById(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookRoomService.getBookingById(bookingId));
    }

    // Get all bookings by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookRoomDto>> getBookingsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(bookRoomService.getBookingsByUser(userId));
    }

    // Get all bookings by room
    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<BookRoomDto>> getBookingsByRoom(@PathVariable String roomId) {
        return ResponseEntity.ok(bookRoomService.getBookingsByRoom(roomId));
    }

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<BookRoomDto>> getAllBookings() {
        return ResponseEntity.ok(bookRoomService.getAllBookings());
    }

    // Delete booking
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable String bookingId) {
        bookRoomService.deleteBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
}
