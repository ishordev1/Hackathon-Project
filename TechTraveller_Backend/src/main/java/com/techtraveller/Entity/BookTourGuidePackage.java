package com.techtraveller.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bookpackage")
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
	@JoinColumn(name = "tourGuide_id")
	@JsonBackReference("tourist_guide_book")
	private TourGuide tourGuide;
	
	  @ManyToMany(mappedBy = "bookedPackages", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  private List<Tourist> tourists;
	  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tourPackage_id")
	@JsonBackReference("tour_package")
	private TourPackage tourPackage;
	
	 public enum AvailabilityStatus {
	        AVAILABLE,
	        FULLY_BOOKED,
	        CANCELLED
	    }

}
