package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.domain.CourierLocationLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface CourierLocationLogRepository extends MongoRepository<CourierLocationLog, String> {

    List<CourierLocationLog> findByCourier(Courier courier);

    Page<CourierLocationLog> findByCourier(Courier courier, PageRequest pageRequest);

}