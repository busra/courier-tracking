package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Store;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<Store> findByLocationNear(Point location, double distanceInMeters) {
        return storeRepository.findByLocationNear(location, new Distance(distanceInMeters / 1_000, Metrics.KILOMETERS));
    }

}