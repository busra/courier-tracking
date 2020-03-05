package com.busra.couriertracking.service;

import com.busra.couriertracking.domain.Location;

import java.util.List;

public interface LocationService {

    void saveLocation();

    List<Location> findAll();

}