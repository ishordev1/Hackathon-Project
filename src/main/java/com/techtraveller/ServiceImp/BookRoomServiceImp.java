package com.techtraveller.ServiceImp;

import com.techtraveller.Dto.BookRoomDto;
import com.techtraveller.Entity.BookRoom;
import com.techtraveller.Entity.Room;
import com.techtraveller.Entity.User;
import com.techtraveller.Exception.BadApiRequest;
import com.techtraveller.Exception.ResourceNotFoundException;
import com.techtraveller.Repository.BookRoomRepository;
import com.techtraveller.Repository.RoomRepository;
import com.techtraveller.Repository.UserRepository;
import com.techtraveller.Service.BookRoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookRoomServiceImp implements BookRoomService {

    private final BookRoomRepository bookRoomRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public BookRoomDto createBooking(BookRoomDto bookingDto, String roomId, String userId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Check if any ACCEPTED booking already exists
        List<BookRoom> acceptedBookings = bookRoomRepository.findOverlappingAcceptedBookings(
                roomId, bookingDto.getCheckInDateTime(), bookingDto.getCheckOutDateTime()
        );
        if (!acceptedBookings.isEmpty()) {
            throw new BadApiRequest("Room is not available for the selected time slot.");
        }

        // Create PENDING booking
        long durationInMinutes = Duration.between(
                bookingDto.getCheckInDateTime().toInstant(),
                bookingDto.getCheckOutDateTime().toInstant()
        ).toMinutes();

        double totalPrice = (room.getPricePerHour() / 60) * durationInMinutes;

        BookRoom booking = modelMapper.map(bookingDto, BookRoom.class);
        booking.setRoom(room);
        booking.setUser(user);
        booking.setDurationInMinutes(durationInMinutes);
        booking.setTotalPrice(totalPrice);
        booking.setStatus("PENDING");
        booking.setBookingCreatedAt(new Date());

        BookRoom savedBooking = bookRoomRepository.save(booking);
        return modelMapper.map(savedBooking, BookRoomDto.class);
    }

    @Override
    public BookRoomDto updateBookingStatus(String bookingId, String status) {
        BookRoom booking = bookRoomRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        booking.setStatus(status);

        // If ACCEPTED, cancel all overlapping pending bookings
        if ("ACCEPTED".equalsIgnoreCase(status)) {
            List<BookRoom> pendingBookings = bookRoomRepository.findOverlappingPendingBookings(
                    booking.getRoom().getRoomId(),
                    booking.getCheckInDateTime(),
                    booking.getCheckOutDateTime()
            );

            for (BookRoom b : pendingBookings) {
                if (!b.getBookingId().equals(booking.getBookingId())) {
                    b.setStatus("CANCELLED");
                }
            }
            bookRoomRepository.saveAll(pendingBookings);
        }

        BookRoom updatedBooking = bookRoomRepository.save(booking);
        return modelMapper.map(updatedBooking, BookRoomDto.class);
    }

    @Override
    public BookRoomDto getBookingById(String bookingId) {
        BookRoom booking = bookRoomRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        return modelMapper.map(booking, BookRoomDto.class);
    }

    @Override
    public List<BookRoomDto> getBookingsByUser(String userId) {
        return bookRoomRepository.findByUserUserId(userId)
                .stream()
                .map(b -> modelMapper.map(b, BookRoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookRoomDto> getBookingsByRoom(String roomId) {
        return bookRoomRepository.findByRoomRoomId(roomId)
                .stream()
                .map(b -> modelMapper.map(b, BookRoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookRoomDto> getAllBookings() {
        return bookRoomRepository.findAll()
                .stream()
                .map(b -> modelMapper.map(b, BookRoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(String bookingId) {
        BookRoom booking = bookRoomRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        bookRoomRepository.delete(booking);
    }
}
