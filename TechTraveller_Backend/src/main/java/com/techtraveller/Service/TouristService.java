package com.techtraveller.Service;


//import com.techtraveller.Dto.BookTourGuideDto;
import com.techtraveller.Dto.TouristDto;
import java.util.List;

public interface TouristService {

    TouristDto createTourist(TouristDto touristDto);

    TouristDto getTouristById(String id);

    List<TouristDto> getAllTourists();

    TouristDto updateTourist(String id, TouristDto touristDto);

    void deleteTourist(String id);
    
//    public BookTourGuideDto bookTourGuide(BookTourGuideDto bookTourGuideDto);
    
}

