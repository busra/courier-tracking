package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.domain.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationDaoImpl implements LocationDao {

    private LocationRepository locationRepository;

    LocationDaoImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public List<Location> findByCourierId(String courierId) {
        return null; // TODO: nasıl yapcez
    }

}