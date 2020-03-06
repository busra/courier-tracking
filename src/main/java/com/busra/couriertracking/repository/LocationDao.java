package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Location;

import java.util.List;

public interface LocationDao {

    void saveLocation(Location location);

    List<Location> findByCourierId(String courierId);

}