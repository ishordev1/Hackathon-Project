package com.techtraveller.Controller;

import com.techtraveller.Dto.ApiResponse;
import com.techtraveller.Dto.BookTourGuidePackageDto;
import com.techtraveller.Dto.TourPackageDto;
import com.techtraveller.Service.BookTourGuidePackageService;
import com.techtraveller.Service.TourPackageService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
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
    
  

    @PostMapping("/tourguide/{tourGuideId}")
    public ResponseEntity<TourPackageDto> createTourPackage(
            @PathVariable("tourGuideId") String tourGuideId,
            @RequestBody TourPackageDto tourPackageDto) {
        TourPackageDto createdTourPackage = tourPackageService.createTourPackageByTourGuideId(tourGuideId, tourPackageDto);
        return new ResponseEntity<>(createdTourPackage, HttpStatus.CREATED);
    }

    @PutMapping("/tourguide/{tourGuideId}/{id}")
    public ResponseEntity<TourPackageDto> updateTourPackage(
            @PathVariable("tourGuideId") String tourGuideId,
            @PathVariable("id") String id,
            @RequestBody TourPackageDto tourPackageDto) {
        TourPackageDto updatedTourPackage = tourPackageService.updateTourPackageByTourGuideId(tourGuideId, id, tourPackageDto);
        return new ResponseEntity<>(updatedTourPackage, HttpStatus.OK);
    }

    @GetMapping("/{id}/tourguide/{tourGuideId}")
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

    @GetMapping("/tourguide/{tourGuideId}")
    public ResponseEntity<List<TourPackageDto>> getAllTourPackagesByTourGuideId(
            @PathVariable("tourGuideId") String tourGuideId) {
        List<TourPackageDto> tourPackages = tourPackageService.getAllTourPackagesByTourGuideId(tourGuideId);
        return new ResponseEntity<>(tourPackages, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/tourguide/{tourGuideId}")
    public ResponseEntity<ApiResponse> deleteTourPackage(
            @PathVariable("tourGuideId") String tourGuideId,
            @PathVariable("id") String id) {
        tourPackageService.deleteTourPackageByTourGuideId(tourGuideId, id);
        ApiResponse apiResponse = ApiResponse.builder().message("Delete Successfully").success(true).Status(HttpStatus.OK).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    
    
    //booking package
    
    
    
    @PostMapping("/{packageId}/bookPackage/tourist/{touristId}")
    public ResponseEntity<BookTourGuidePackageDto> bookTourPackage(
            @PathVariable("touristId") String touristId,
            @PathVariable("packageId") String packageId,
            @RequestBody BookTourGuidePackageDto bookPackage) {
BookTourGuidePackageDto bookTourGuidePackage = this.bookTourGuidePackageService.createBookTourGuidePackage(bookPackage, packageId, touristId);
    	
return new ResponseEntity<>(bookTourGuidePackage, HttpStatus.CREATED);
    }
    
    @GetMapping("/bookedpackage")
    public ResponseEntity<List<BookTourGuidePackageDto>> getAllBookedPackage(){
    	List<BookTourGuidePackageDto> allBookTourGuidePackages = this.bookTourGuidePackageService.getAllBookTourGuidePackages();
    	return new ResponseEntity<>(allBookTourGuidePackages,HttpStatus.OK);
    }
    
    @GetMapping("/bookedpackage/{packageId}")
    public ResponseEntity<List<BookTourGuidePackageDto>> getAllBookedPackage(@PathVariable String packageId){
    	List<BookTourGuidePackageDto> allBookTourGuidePackages = this.bookTourGuidePackageService.getBookTourGuidePackageByPackageId(packageId);
    	return new ResponseEntity<>(allBookTourGuidePackages,HttpStatus.OK);
    }
    
    @GetMapping("/{packageId}/cancelbookedpackagebytourist/{touristId}")
    public ResponseEntity<ApiResponse> cancelpackage
    (@PathVariable String packageId, @PathVariable String touristId){
    	boolean check = this.bookTourGuidePackageService.cancelBookTourGuidePackage(packageId, touristId);
    ApiResponse apiResponse=null;
    if(check) {
    	ApiResponse.builder().message("Your tourpackage are cancel successfully")
    	.success(true)
    	.Status(HttpStatus.OK).build();
    }
    else {
    	ApiResponse.builder().message("sorry your package is not cancel")
    	.success(true)
    	.Status(HttpStatus.OK).build();
    }
    
    return new ResponseEntity<>(ApiResponse,HttpStatus.OK);
    
    }
    
}
