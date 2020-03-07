package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Courier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourierDao {

    private final CourierRepository courierRepository;

    private final MongoTemplate mongoTemplate;

    CourierDao(CourierRepository courierRepository, MongoTemplate mongoTemplate) {
        this.courierRepository = courierRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public void save(Courier courier) {
        courierRepository.save(courier);
    }

    public Optional<Courier> findById(String courierId) {
        return courierRepository.findById(courierId);
    }

    public List<Courier> findAll() {
        return courierRepository.findAll();
    }
}