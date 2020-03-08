package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Store;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

interface StoreRepository extends MongoRepository<Store, String> {

    Optional<Store> findFirstByLocationNear(Point location, Distance distance);

}