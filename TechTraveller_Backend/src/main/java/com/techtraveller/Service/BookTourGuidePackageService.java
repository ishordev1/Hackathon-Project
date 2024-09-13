package com.techtraveller.Service;


import com.techtraveller.Dto.BookTourGuidePackageDto;

import java.time.LocalDate;
import java.util.List;

public interface BookTourGuidePackageService {
   
	
	
	
	public BookTourGuidePackageDto createBookTourGuidePackage(BookTourGuidePackageDto packageDto, String packageId, String tourGuideId, String touristId);

//    BookTourGuidePackageDto updateBookTourGuidePackage(BookTourGuidePackageDto packageDto,String bookpackageId, String packageId, String tourGuideId, String touristId);
//
//    void deleteBookTourGuidePackage(String packageId);
//
//    BookTourGuidePackageDto getBookTourGuidePackageById(String packageId);
//
//    List<BookTourGuidePackageDto> getAllBookTourGuidePackages();
//
//    List<BookTourGuidePackageDto> getPackagesByTourGuideId(String tourGuideId);
//
//    List<BookTourGuidePackageDto> getPackagesByTourPackageId(String tourPackageId);
}
