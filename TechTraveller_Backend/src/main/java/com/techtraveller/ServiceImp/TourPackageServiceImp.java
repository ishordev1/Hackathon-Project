package com.techtraveller.ServiceImp;

import com.techtraveller.Dto.TourPackageDto;
import com.techtraveller.Entity.TourPackage;
import com.techtraveller.Exception.ResourceNotFoundException;
import com.techtraveller.Entity.TourGuide;
import com.techtraveller.Repository.TourPackageRepository;
import com.techtraveller.Repository.TourGuideRepository;
import com.techtraveller.Service.TourPackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourPackageServiceImp implements TourPackageService {

    @Autowired
    private TourPackageRepository tourPackageRepository;

    @Autowired
    private TourGuideRepository tourGuideRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TourPackageDto createTourPackageByTourGuideId(String tourGuideId, TourPackageDto tourPackageDto) {
        TourGuide tourGuide = tourGuideRepository.findById(tourGuideId)
                .orElseThrow(() -> new ResourceNotFoundException("Tour Guide not found"));
        
        TourPackage tourPackage = modelMapper.map(tourPackageDto, TourPackage.class);
        tourPackage.setTourGuide(tourGuide);
        
        TourPackage savedTourPackage = tourPackageRepository.save(tourPackage);

        return modelMapper.map(savedTourPackage, TourPackageDto.class);
    }

    @Override
    public TourPackageDto updateTourPackageByTourGuideId(String tourGuideId, String id, TourPackageDto tourPackageDto) {
        TourGuide tourGuide = tourGuideRepository.findById(tourGuideId)
                .orElseThrow(() -> new ResourceNotFoundException("Tour Guide not found"));
        
        TourPackage existingTourPackage = tourPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour Package not found"));

        if (!existingTourPackage.getTourGuide().getId().equals(tourGuideId)) {
            throw new ResourceNotFoundException("Tour Package does not belong to the given Tour Guide");
        }

        modelMapper.map(tourPackageDto, existingTourPackage);
        existingTourPackage.setTourGuide(tourGuide);
        TourPackage updatedTourPackage = tourPackageRepository.save(existingTourPackage);

        return modelMapper.map(updatedTourPackage, TourPackageDto.class);
    }

    @Override
    public TourPackageDto getTourPackageByIdByTourGuideId(String tourGuideId, String id) {
        TourGuide tourGuide = tourGuideRepository.findById(tourGuideId)
                .orElseThrow(() -> new ResourceNotFoundException("Tour Guide not found"));

        TourPackage tourPackage = tourPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour Package not found"));

        if (!tourPackage.getTourGuide().getId().equals(tourGuideId)) {
            throw new ResourceNotFoundException("Tour Package does not belong to the given Tour Guide");
        }

        return modelMapper.map(tourPackage, TourPackageDto.class);
    }

    @Override
    public List<TourPackageDto> getAllTourPackages() {
        return tourPackageRepository.findAll().stream()
                .map(tourPackage -> modelMapper.map(tourPackage, TourPackageDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TourPackageDto> getAllTourPackagesByTourGuideId(String tourGuideId) {
        TourGuide tourGuide = tourGuideRepository.findById(tourGuideId)
                .orElseThrow(() -> new ResourceNotFoundException("Tour Guide not found"));

        return tourPackageRepository.findByTourGuideId(tourGuide.getId()).stream()
                .map(tourPackage -> modelMapper.map(tourPackage, TourPackageDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTourPackageByTourGuideId(String tourGuideId, String id) {
        TourGuide tourGuide = tourGuideRepository.findById(tourGuideId)
                .orElseThrow(() -> new ResourceNotFoundException("Tour Guide not found"));

        TourPackage tourPackage = tourPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tour Package not found"));

        if (!tourPackage.getTourGuide().getId().equals(tourGuideId)) {
            throw new ResourceNotFoundException("Tour Package does not belong to the given Tour Guide");
        }

        tourPackageRepository.delete(tourPackage);
    }
}
