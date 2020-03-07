package com.busra.couriertracking.service;

import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.repository.CourierDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierService {

    private final CourierDao courierDao;

    CourierService(CourierDao courierRepository) {
        this.courierDao = courierRepository;
    }

    public List<Courier> findAll() {
        return courierDao.findAll();
    }

}