package com.techtraveller.ServiceImp;

import com.techtraveller.Dto.BookTourGuidePackageDto;
import com.techtraveller.Dto.TouristDto;
import com.techtraveller.Entity.BookTourGuidePackage;
import com.techtraveller.Entity.PaymentStatus;
import com.techtraveller.Entity.TourGuide;
import com.techtraveller.Entity.TourPackage;
import com.techtraveller.Entity.Tourist;
import com.techtraveller.Exception.ResourceNotFoundException;
import com.techtraveller.Repository.BookTourGuidePackageRepository;
import com.techtraveller.Repository.TourGuideRepository;
import com.techtraveller.Repository.TourPackageRepository;
import com.techtraveller.Repository.TouristRepository;
import com.techtraveller.Service.BookTourGuidePackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BookTourGuidePackageServiceImp implements BookTourGuidePackageService {

	@Autowired
	private BookTourGuidePackageRepository bookTourGuidePackageRepository;

	@Autowired
	private TourGuideRepository tourGuideRepository;

	@Autowired
	private TourPackageRepository tourPackageRepository;

	@Autowired
	private TouristRepository touristRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookTourGuidePackageDto createBookTourGuidePackage(BookTourGuidePackageDto packageDto, String packageId,
			String touristId) {

		BookTourGuidePackage bookTourGuidePackage = this.modelMapper.map(packageDto, BookTourGuidePackage.class);

		// Fetching entities from repositories
		TourPackage tourPackage = this.tourPackageRepository.findById(packageId)
				.orElseThrow(() -> new ResourceNotFoundException("Tour package not found"));
		TourGuide tourGuide = this.tourGuideRepository.findById(tourPackage.getTourGuide().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Tour guide not found"));
		Tourist tourist = this.touristRepository.findById(touristId)
				.orElseThrow(() -> new ResourceNotFoundException("Tourist not found"));

		// Setting details in the DTO
		bookTourGuidePackage.setPaymentStatus(PaymentStatus.PAYMENT_SUCCESSFUL);
		bookTourGuidePackage.setBookingDate(new Date());
		bookTourGuidePackage.setTourGuide(tourGuide);
		bookTourGuidePackage.setTourPackage(tourPackage);

		List<Tourist> list = new ArrayList<>();
		list.add(tourist);
		bookTourGuidePackage.setTourists(list);

		BookTourGuidePackage savedPackage = this.bookTourGuidePackageRepository.save(bookTourGuidePackage);

		return this.modelMapper.map(savedPackage, BookTourGuidePackageDto.class);
	}

//    @Override
//    public BookTourGuidePackageDto updateBookTourGuidePackage(String packageId, BookTourGuidePackageDto packageDto) {
//        BookTourGuidePackage existingPackage = bookTourGuidePackageRepository.findById(packageId)
//                .orElseThrow(() -> new ResourceNotFoundException("Book Tour Guide Package not found"));
//
//        modelMapper.map(packageDto, existingPackage);
//
//        TourGuide tourGuide = tourGuideRepository.findById(packageDto.getTourGuideId())
//                .orElseThrow(() -> new ResourceNotFoundException("Tour Guide not found"));
//        existingPackage.setTourGuide(tourGuide);
//
//        TourPackage tourPackage = tourPackageRepository.findById(packageDto.getTourPackage().getTourPackageId())
//                .orElseThrow(() -> new ResourceNotFoundException("Tour Package not found"));
//        existingPackage.setTourPackage(tourPackage);
//
//        BookTourGuidePackage updatedPackage = bookTourGuidePackageRepository.save(existingPackage);
//        return modelMapper.map(updatedPackage, BookTourGuidePackageDto.class);
//    }
//
//    @Override
//    public void deleteBookTourGuidePackage(String packageId) {
//        if (!bookTourGuidePackageRepository.existsById(packageId)) {
//            throw new ResourceNotFoundException("Book Tour Guide Package not found");
//        }
//        bookTourGuidePackageRepository.deleteById(packageId);
//    }
//
    @Override
    public List<BookTourGuidePackageDto> getBookTourGuidePackageByPackageId(String packageId) {
        List<BookTourGuidePackage> list = bookTourGuidePackageRepository.findByTourPackageTourPackageId(packageId);
               
        return  list.stream().map(pack-> this.modelMapper.map(pack, BookTourGuidePackageDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookTourGuidePackageDto> getAllBookTourGuidePackages() {
        List<BookTourGuidePackage> packages = bookTourGuidePackageRepository.findAll();
        return packages.stream()
              .map(packag -> this.modelMapper.map(packag, BookTourGuidePackageDto.class))
              .collect(Collectors.toList());
        		}
//
//    @Override
//    public List<BookTourGuidePackageDto> getPackagesByTourGuideId(String tourGuideId) {
//        List<BookTourGuidePackage> packages = bookTourGuidePackageRepository.findByTourGuide_TourGuideId(tourGuideId);
//        return packages.stream()
//                .map(package -> modelMapper.map(package, BookTourGuidePackageDto.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<BookTourGuidePackageDto> getPackagesByTourPackageId(String tourPackageId) {
//        List<BookTourGuidePackage> packages = bookTourGuidePackageRepository.findByTourPackage_PackageId(tourPackageId);
//        return packages.stream()
//                .map(package -> modelMapper.map(package, BookTourGuidePackageDto.class))
//                .collect(Collectors.toList());
//    }

    @Override
    public boolean cancelBookTourGuidePackage(String packageId, String touristId) {
        BookTourGuidePackage bookedPackage = bookTourGuidePackageRepository.findById(packageId)
                .orElseThrow(() -> new ResourceNotFoundException("Book Tour Guide Package not found"));

        Tourist tourist = touristRepository.findById(touristId)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found"));

        if (!bookedPackage.getTourists().contains(tourist)) {
            throw new IllegalStateException("Tourist does not have this package booked.");
        }

        bookedPackage.getTourists().remove(tourist);

        if (bookedPackage.getTourists().isEmpty()) {
            bookTourGuidePackageRepository.delete(bookedPackage);
            return true;
        } else {
            bookTourGuidePackageRepository.save(bookedPackage);
            return false;
        }
    }


}
