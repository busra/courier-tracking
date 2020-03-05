package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Location;

public interface LocationDao {

    void saveLocation(Location location);

}