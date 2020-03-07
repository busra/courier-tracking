package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Store;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class StoreDao {

    private final StoreRepository storeRepository;

    private final MongoTemplate mongoTemplate;

    StoreDao(StoreRepository storeRepository, MongoTemplate mongoTemplate) {
        this.storeRepository = storeRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public void save(Store store) {
        storeRepository.save(store);
    }

}