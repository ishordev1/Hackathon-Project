package com.techtraveller.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import com.techtraveller.Dto.BookTourGuideDto;
//import com.techtraveller.Entity.BookTourGuide.BookingStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookTourGuidePackage {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	
	private String bookingPackageId;

//	@Column(name = "booking_date", nullable = false)
	private Date bookingDate;

//	@Column(name = "payment_status", nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

//	@Column(name = "seat_count", nullable = false)
	private Integer seatCount;

//	@Column(name = "total_amount", nullable = false)
	private Long totalAmount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tour_Guide_Id")
	private TourGuide tourGuide;

	@OneToMany(mappedBy = "bookingTourGuidePackage", cascade = CascadeType.ALL)
	private List<Tourist> tourists=new ArrayList<>();

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tourPackage_id")
	private TourPackage tourPackage;
	
	 public enum AvailabilityStatus {
	        AVAILABLE,
	        FULLY_BOOKED,
	        CANCELLED
	    }

}
