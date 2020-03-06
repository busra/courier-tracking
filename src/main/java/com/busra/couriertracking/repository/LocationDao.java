package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Location;

import java.util.List;

public interface LocationDao {

    void saveLocation(Location location);

    //@Query({"headers.response.status": "?1"})
    List<Location> findByCourierId(String courierId);

}