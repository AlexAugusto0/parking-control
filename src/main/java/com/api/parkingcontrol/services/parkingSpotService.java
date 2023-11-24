package com.api.parkingcontrol.services;

import jakarta.transaction.Transactional;
import com.api.parkingcontrol.models.parkingSpotModel;
import com.api.parkingcontrol.repositories.parkingSpotRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class parkingSpotService {

     final parkingSpotRepository parkingSpotRepository;

     public parkingSpotService(parkingSpotRepository parkingSpotRepository){
         this.parkingSpotRepository = parkingSpotRepository;
     }

     @Transactional
    public parkingSpotModel save(parkingSpotModel parkingSpotModel) {
         return parkingSpotRepository.save(parkingSpotModel);
    }


    public boolean existsByLicensePlateCar(String licensePlateCar) {
         return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
         return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
         return parkingSpotRepository.existsByApartmentAndBlock(apartment,block);
    }

    public Page<parkingSpotModel> findAll(Pageable pageable) {
         return parkingSpotRepository.findAll(pageable);
    }

    public Optional<parkingSpotModel> findById(UUID id) {
         return parkingSpotRepository.findById(id);
    }

    public void delete(parkingSpotModel parkingSpotModel) {
         parkingSpotRepository.delete(parkingSpotModel);
    }
}
