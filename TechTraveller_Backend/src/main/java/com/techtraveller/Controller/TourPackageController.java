package com.techtraveller.Controller;

import com.techtraveller.Dto.ApiResponse;
import com.techtraveller.Dto.BookTourGuidePackageDto;
import com.techtraveller.Dto.TourPackageDto;
import com.techtraveller.Service.BookTourGuidePackageService;
import com.techtraveller.Service.TourPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tour-packages")
public class TourPackageController {

    @Autowired
    private TourPackageService tourPackageService;
    
    @Autowired
    private BookTourGuidePackageService bookTourGuidePackageService;

    @PostMapping("/{tourGuideId}")
    public ResponseEntity<TourPackageDto> createTourPackage(
            @PathVariable("tourGuideId") String tourGuideId,
            @RequestBody TourPackageDto tourPackageDto) {
        TourPackageDto createdTourPackage = tourPackageService.createTourPackageByTourGuideId(tourGuideId, tourPackageDto);
        return new ResponseEntity<>(createdTourPackage, HttpStatus.CREATED);
    }

    @PutMapping("/{tourGuideId}/{id}")
    public ResponseEntity<TourPackageDto> updateTourPackage(
            @PathVariable("tourGuideId") String tourGuideId,
            @PathVariable("id") String id,
            @RequestBody TourPackageDto tourPackageDto) {
        TourPackageDto updatedTourPackage = tourPackageService.updateTourPackageByTourGuideId(tourGuideId, id, tourPackageDto);
        return new ResponseEntity<>(updatedTourPackage, HttpStatus.OK);
    }

    @GetMapping("/{tourGuideId}/{id}")
    public ResponseEntity<TourPackageDto> getTourPackageById(
            @PathVariable("tourGuideId") String tourGuideId,
            @PathVariable("id") String id) {
        TourPackageDto tourPackageDto = tourPackageService.getTourPackageByIdByTourGuideId(tourGuideId, id);
        return new ResponseEntity<>(tourPackageDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TourPackageDto>> getAllTourPackages() {
        List<TourPackageDto> tourPackages = tourPackageService.getAllTourPackages();
        return new ResponseEntity<>(tourPackages, HttpStatus.OK);
    }

    @GetMapping("/tour-guide/{tourGuideId}")
    public ResponseEntity<List<TourPackageDto>> getAllTourPackagesByTourGuideId(
            @PathVariable("tourGuideId") String tourGuideId) {
        List<TourPackageDto> tourPackages = tourPackageService.getAllTourPackagesByTourGuideId(tourGuideId);
        return new ResponseEntity<>(tourPackages, HttpStatus.OK);
    }

    @DeleteMapping("/{tourGuideId}/{id}")
    public ResponseEntity<ApiResponse> deleteTourPackage(
            @PathVariable("tourGuideId") String tourGuideId,
            @PathVariable("id") String id) {
        tourPackageService.deleteTourPackageByTourGuideId(tourGuideId, id);
        ApiResponse apiResponse = ApiResponse.builder().message("Delete Successfully").success(true).Status(HttpStatus.OK).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    
    
    
    
    
    
//    @PostMapping("/bookPackage/{}")
//    public ResponseEntity<TourPackageDto> bookTourPackage(
//            @PathVariable("tourGuideId") String tourGuideId,
//            @RequestBody BookTourGuidePackageDto bookPackage) {
//        TourPackageDto createdTourPackage = tourPackageService.createTourPackageByTourGuideId(tourGuideId, tourPackageDto);
//        return new ResponseEntity<>(createdTourPackage, HttpStatus.CREATED);
//    }
    
}
