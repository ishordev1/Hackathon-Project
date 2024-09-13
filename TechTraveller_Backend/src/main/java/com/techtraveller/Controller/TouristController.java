package com.techtraveller.Controller;


import com.techtraveller.Dto.ApiResponse;
//import com.techtraveller.Dto.BookTourGuideDto;
import com.techtraveller.Dto.TouristDto;
import com.techtraveller.Service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    @Autowired
    private TouristService touristService;

    @PostMapping
    public ResponseEntity<TouristDto> createTourist(@RequestBody TouristDto touristDto) {
        TouristDto createdTourist = touristService.createTourist(touristDto);
        return ResponseEntity.ok(createdTourist);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TouristDto> getTouristById(@PathVariable String id) {
        TouristDto touristDto = touristService.getTouristById(id);
        return ResponseEntity.ok(touristDto);
    }

    @GetMapping
    public ResponseEntity<List<TouristDto>> getAllTourists() {
        List<TouristDto> tourists = touristService.getAllTourists();
        return ResponseEntity.ok(tourists);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TouristDto> updateTourist(@PathVariable String id, @RequestBody TouristDto touristDto) {
       System.out.println("test");
    	TouristDto updatedTourist = touristService.updateTourist(id, touristDto);
        return ResponseEntity.ok(updatedTourist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTourist(@PathVariable String id) {
        touristService.deleteTourist(id);
        ApiResponse apiResponse=ApiResponse.builder()
        		.message("delete successfully tourist")
        		.success(true)
        		.Status(HttpStatus.OK).build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
    
    
    
//    @PostMapping("/book-guide")
//    public ResponseEntity<BookTourGuideDto> bookTourGuide(
//    		@RequestBody BookTourGuideDto bookTourGuideDto
//    	) {
//    	
//        BookTourGuideDto bookedGuide = touristService.bookTourGuide(bookTourGuideDto);
//        return new ResponseEntity<>(bookedGuide, HttpStatus.CREATED);
//    }
}











