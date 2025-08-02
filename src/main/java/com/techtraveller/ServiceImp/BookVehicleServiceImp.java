package com.techtraveller.ServiceImp;

import com.techtraveller.Dto.BookVehicleDto;
import com.techtraveller.Entity.BookVehicle;
import com.techtraveller.Entity.User;
import com.techtraveller.Entity.Vehicle;
import com.techtraveller.Exception.BadApiRequest;
import com.techtraveller.Exception.ResourceNotFoundException;
import com.techtraveller.Repository.BookVehicleRepository;
import com.techtraveller.Repository.UserRepository;
import com.techtraveller.Repository.VehicleRepository;
import com.techtraveller.Service.BookVehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookVehicleServiceImp implements BookVehicleService {

    private final BookVehicleRepository bookingRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public BookVehicleDto createBooking(BookVehicleDto bookingDto, String vehicleId, String userId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Validate time
        if (bookingDto.getEndDateTime().before(bookingDto.getStartDateTime())) {
            throw new BadApiRequest("End time must be after start time.");
        }

        // Check availability: only block if an ACCEPTED or ONGOING booking exists
        List<BookVehicle> overlappingBookings = bookingRepository.findOverlappingBookings(
                vehicleId, bookingDto.getStartDateTime(), bookingDto.getEndDateTime()
        );

        if (!overlappingBookings.isEmpty()) {
            throw new BadApiRequest("Vehicle is not available for the selected time slot.");
        }

        // Calculate duration & price
        long durationInMinutes = Duration.between(
                bookingDto.getStartDateTime().toInstant(),
                bookingDto.getEndDateTime().toInstant()
        ).toMinutes();

        double totalPrice = (vehicle.getPricePerHour() / 60) * durationInMinutes;

        BookVehicle booking = modelMapper.map(bookingDto, BookVehicle.class);
        booking.setVehicle(vehicle);
        booking.setUser(user);
        booking.setDurationInMinutes(durationInMinutes);
        booking.setTotalPrice(totalPrice);
        booking.setStatus("PENDING"); // Still pending until owner accepts
        booking.setBookingCreatedAt(new Date());

        BookVehicle savedBooking = bookingRepository.save(booking);
        return modelMapper.map(savedBooking, BookVehicleDto.class);
    }



    @Override
    public BookVehicleDto updateBookingStatus(String bookingId, String status) {
        BookVehicle booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        // Accepting booking: check conflict
        if (status.equalsIgnoreCase("ACCEPTED")) {
            List<BookVehicle> overlappingBookings = bookingRepository.findOverlappingBookings(
                    booking.getVehicle().getVehicleId(),
                    booking.getStartDateTime(),
                    booking.getEndDateTime()
            );

            // If any other ACCEPTED/ONGOING bookings exist, block acceptance
            if (!overlappingBookings.isEmpty()) {
                throw new BadApiRequest("Vehicle is already booked for this time slot.");
            }

            // ✅ Auto-cancel all other PENDING bookings for the same time slot
            List<BookVehicle> pendingBookings = bookingRepository.findPendingBookings(
                    booking.getVehicle().getVehicleId(),
                    booking.getStartDateTime(),
                    booking.getEndDateTime(),
                    bookingId // exclude the current booking
            );

            for (BookVehicle pending : pendingBookings) {
                pending.setStatus("CANCELLED");
                bookingRepository.save(pending);
            }
        }

        booking.setStatus(status.toUpperCase());
        BookVehicle updatedBooking = bookingRepository.save(booking);
        return modelMapper.map(updatedBooking, BookVehicleDto.class);
    }



    @Override
    public BookVehicleDto getBookingById(String bookingId) {
        BookVehicle booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        return modelMapper.map(booking, BookVehicleDto.class);
    }

    @Override
    public List<BookVehicleDto> getBookingsByUser(String userId) {
        return bookingRepository.findByUserUserId(userId).stream()
                .map(booking -> modelMapper.map(booking, BookVehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookVehicleDto> getBookingsByVehicle(String vehicleId) {
        return bookingRepository.findByVehicleVehicleId(vehicleId).stream()
                .map(booking -> modelMapper.map(booking, BookVehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookVehicleDto> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(booking -> modelMapper.map(booking, BookVehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(String bookingId) {
        BookVehicle booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        bookingRepository.delete(booking);
    }
}
