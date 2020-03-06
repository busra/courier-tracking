package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Courier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends MongoRepository<Courier, String> {

}