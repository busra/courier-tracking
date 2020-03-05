package com.busra.couriertracking.service;

import com.busra.couriertracking.domain.Location;
import com.busra.couriertracking.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void saveLocation() {
        try {
            Location location1 = new Location("bookOsman", "busra");
            Location location2 = new Location("bookOsman2", "busra2");
            Location location3 = new Location("bookOsman3", "busra3");
            Location location4 = new Location("bookOsman4", "busra4");

            locationRepository.save(location1);
            locationRepository.save(location2);
            locationRepository.save(location3);
            locationRepository.save(location4);
        } catch (Exception e) {
            System.out.println("test");
        }
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

}