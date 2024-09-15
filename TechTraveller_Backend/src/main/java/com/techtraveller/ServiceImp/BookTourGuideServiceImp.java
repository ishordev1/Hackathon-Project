//package com.techtraveller.ServiceImp;
//
//
//import com.techtraveller.Dto.BookTourGuideDto;
//import com.techtraveller.Entity.BookTourGuide;
//import com.techtraveller.Repository.BookTourGuideRepository;
//import com.techtraveller.Service.BookTourGuideService;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class BookTourGuideServiceImp implements BookTourGuideService {
//
//    @Autowired
//    private BookTourGuideRepository bookGuideRepository;
//
//    @Autowired
//    private  ModelMapper modelMapper;
//
//    @Override
//    public BookTourGuideDto createBooking(BookTourGuideDto bookGuideDto) {
//        BookTourGuide bookGuide = modelMapper.map(bookGuideDto, BookTourGuide.class);
//        BookTourGuide savedBookGuide = bookGuideRepository.save(bookGuide);
//        return modelMapper.map(savedBookGuide, BookTourGuideDto.class);
//    }
//
//    @Override
//    public BookTourGuideDto updateBooking(String id, BookTourGuideDto bookGuideDto) {
//        BookTourGuide existingBookGuide = bookGuideRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
//
//        modelMapper.map(bookGuideDto, existingBookGuide);
//        BookTourGuide updatedBookGuide = bookGuideRepository.save(existingBookGuide);
//        return modelMapper.map(updatedBookGuide, BookTourGuideDto.class);
//    }
//
//    @Override
//    public BookTourGuideDto getBookingById(String id) {
//        BookTourGuide bookGuide = bookGuideRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
//        return modelMapper.map(bookGuide, BookTourGuideDto.class);
//    }
//
//    @Override
//    public List<BookTourGuideDto> getAllBookings() {
//        List<BookTourGuide> bookings = bookGuideRepository.findAll();
//        return bookings.stream()
//                .map(bookGuide -> modelMapper.map(bookGuide, BookTourGuideDto.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteBooking(String id) {
//        BookTourGuide bookGuide = bookGuideRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
//        bookGuideRepository.delete(bookGuide);
//    }
//}
//
