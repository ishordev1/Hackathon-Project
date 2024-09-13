package com.techtraveller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.techtraveller.Dto.ApiResponse;
import com.techtraveller.Dto.TourGuideDto;
import com.techtraveller.Service.TourGuideService;

import java.util.List;

@RestController
@RequestMapping("/api/tour-guides")
public class TourGuideController {

    @Autowired
    private TourGuideService tourGuideService;



    @GetMapping("/{id}")
    public ResponseEntity<TourGuideDto> getTourGuideById(@PathVariable String id) {
        TourGuideDto tourGuideDto = tourGuideService.getTourGuideById(id);
        return new ResponseEntity<>(tourGuideDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TourGuideDto>> getAllTourGuides() {
        List<TourGuideDto> tourGuideDtos = tourGuideService.getAllTourGuides();
        return new ResponseEntity<>(tourGuideDtos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourGuideDto> updateTourGuide(@PathVariable String id, @RequestBody TourGuideDto tourGuideDto) {
        TourGuideDto updatedTourGuide = tourGuideService.updateTourGuide(id, tourGuideDto);
        return new ResponseEntity<>(updatedTourGuide, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTourGuide(@PathVariable String id) {
        tourGuideService.deleteTourGuide(id);
        ApiResponse apiResponse=ApiResponse.builder()
        		.message("delete tourGuide")
        		.success(true)
        		.Status(HttpStatus.OK)
        		.build();
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
    
    
    @PostMapping("/{email}")
    public ResponseEntity<TourGuideDto> getTourGuideByEmail(@PathVariable String email) {
//    	System.out.println("this email found:"+email);
        TourGuideDto tourGuideDto = tourGuideService.getTourGuideByEmail(email);
        return new ResponseEntity<>(tourGuideDto,HttpStatus.OK);
    }

}
