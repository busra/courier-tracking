package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Courier;
import org.springframework.data.mongodb.repository.MongoRepository;

interface CourierRepository extends MongoRepository<Courier, String> {
}