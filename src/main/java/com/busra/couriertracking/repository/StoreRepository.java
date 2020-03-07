package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Store;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface StoreRepository extends MongoRepository<Store, String> {

    List<Store> findByLocationNear(Point location, Distance distance);

}