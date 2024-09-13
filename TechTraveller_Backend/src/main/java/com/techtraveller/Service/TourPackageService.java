package com.techtraveller.Service;

import com.techtraveller.Dto.TourPackageDto;
import java.util.List;

public interface TourPackageService {

    TourPackageDto createTourPackageByTourGuideId(String tourGuideId,TourPackageDto tourPackageDto);

    TourPackageDto updateTourPackageByTourGuideId(String tourGuideId, String id, TourPackageDto tourPackageDto);

    TourPackageDto getTourPackageByIdByTourGuideId(String tourGuideId, String id);

    List<TourPackageDto> getAllTourPackages();
    List<TourPackageDto> getAllTourPackagesByTourGuideId(String tourGuideId);
    

    void deleteTourPackageByTourGuideId(String tourGuideId, String id);
}
