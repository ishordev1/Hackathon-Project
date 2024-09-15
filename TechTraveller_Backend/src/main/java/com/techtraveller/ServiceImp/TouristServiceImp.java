package com.techtraveller.ServiceImp;

//import com.techtraveller.Dto.BookTourGuideDto;
import com.techtraveller.Dto.TouristDto;
import com.techtraveller.Dto.UserDto;
//import com.techtraveller.Entity.BookTourGuide;
import com.techtraveller.Entity.TourGuide;
import com.techtraveller.Entity.Tourist;
import com.techtraveller.Entity.User;
import com.techtraveller.Exception.ResourceNotFoundException;
//import com.techtraveller.Repository.BookTourGuideRepository;
import com.techtraveller.Repository.TourGuideRepository;
import com.techtraveller.Repository.TouristRepository;
import com.techtraveller.Repository.UserRepository;
//import com.techtraveller.Service.BookTourGuideService;
import com.techtraveller.Service.TourGuideService;
import com.techtraveller.Service.TouristService;
import com.techtraveller.Service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TouristServiceImp implements TouristService {

    @Autowired
    private TouristRepository touristRepository;
    @Autowired
    private TourGuideRepository tourGuideRepository;
    
//    @Autowired
//private BookTourGuideService bookTourGuideService;
    
    @Autowired
    private ModelMapper modelMapper;

   @Autowired
   private UserService userService;
    
    @Override
    public TouristDto createTourist(TouristDto touristDto) {
    	UserDto saveUser = this.userService.createUser(this.modelMapper.map(touristDto.getUser(), UserDto.class));
    	touristDto.setUser(this.modelMapper.map(saveUser, User.class)); 
    	touristDto.setEmail(saveUser.getEmail());
        Tourist tourist = modelMapper.map(touristDto, Tourist.class);
        Tourist savedTourist = touristRepository.save(tourist);
        return modelMapper.map(savedTourist, TouristDto.class);
    }

    @Override
    public TouristDto getTouristById(String id) {
        Tourist tourist = touristRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found with id: " + id));
        return modelMapper.map(tourist, TouristDto.class);
    }

    @Override
    public List<TouristDto> getAllTourists() {
        List<Tourist> tourists = touristRepository.findAll();
        return tourists.stream()
                .map(tourist -> modelMapper.map(tourist, TouristDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TouristDto updateTourist(String id, TouristDto touristDto) {
        Tourist existingTourist = touristRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found with id: " + id));

        existingTourist.setName(touristDto.getName());
       
       
        existingTourist.setPhoneNumber(touristDto.getPhoneNumber());
        existingTourist.setGender(touristDto.getGender());
        existingTourist.setAddress(touristDto.getAddress());
        existingTourist.setNationality(touristDto.getNationality());

        Tourist updatedTourist = touristRepository.save(existingTourist);
        return modelMapper.map(updatedTourist, TouristDto.class);
    }

    @Override
    public void deleteTourist(String id) {
        Tourist tourist = touristRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found with id: " + id));
        touristRepository.delete(tourist);
    }
    
    
//    @Override
//    public BookTourGuideDto bookTourGuide(BookTourGuideDto bookTourGuideDto) {
//    	
//        Tourist tourist = touristRepository.findById(bookTourGuideDto.getTouristId())
//                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found in this id"+bookTourGuideDto.getTouristId()));
//
//        TourGuide tourGuide = tourGuideRepository.findById(bookTourGuideDto.getTourGuideId())
//                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found in this id"+ bookTourGuideDto.getTourGuideId()));
//       
//        return this.bookTourGuideService.createBooking(bookTourGuideDto);
//        		
//    }
    
    
    
}
