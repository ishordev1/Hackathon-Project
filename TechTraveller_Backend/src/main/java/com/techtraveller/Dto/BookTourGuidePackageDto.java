package com.techtraveller.Dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.techtraveller.Entity.PaymentStatus;
import com.techtraveller.Entity.TourGuide;
import com.techtraveller.Entity.TourPackage;
//import com.techtraveller.Entity.BookTourGuide.BookingStatus;
import com.techtraveller.Entity.Tourist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookTourGuidePackageDto {
	private String bookingPackageId;
	private Date bookingDate;
	private PaymentStatus paymentStatus;
	private Integer seatCount;
	private Long totalAmount;
	private String tourGuideId;
	
	private List<TouristDto> tourists;
	private TourPackageDto tourPackage;
	 
	
	
	
	
}
