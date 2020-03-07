package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.domain.CourierLocationLog;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourierLocationLogDao {

    private final CourierLocationLogRepository courierLocationLogRepository;

    private final MongoTemplate mongoTemplate;

    CourierLocationLogDao(CourierLocationLogRepository courierLocationLogRepository, MongoTemplate mongoTemplate) {
        this.courierLocationLogRepository = courierLocationLogRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public void save(CourierLocationLog courierLocationLog) {
        courierLocationLogRepository.save(courierLocationLog);
    }

    public List<CourierLocationLog> findByCourier(Courier courier) {
        return courierLocationLogRepository.findByCourier(courier);
    }

}