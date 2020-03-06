package com.busra.couriertracking.repository;

import com.busra.couriertracking.domain.Courier;
import org.springframework.stereotype.Service;

@Service
public class CourierDaoImpl implements CourierDao {

    private CourierRepository courierRepository;

    CourierDaoImpl(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    @Override
    public void saveCourier(Courier courier) {
        courierRepository.save(courier);
    }

}