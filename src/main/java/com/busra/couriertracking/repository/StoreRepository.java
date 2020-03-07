package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

interface StoreRepository extends MongoRepository<Store, String> {
}