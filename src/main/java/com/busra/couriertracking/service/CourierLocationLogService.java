package com.busra.couriertracking.service;

import com.busra.couriertracking.controller.model.LocationLogRequest;
import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.domain.CourierLocationLog;
import com.busra.couriertracking.repository.CourierDao;
import com.busra.couriertracking.repository.CourierLocationLogDao;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourierLocationLogService {

    private final CourierLocationLogDao courierLocationLogDao;

    private final CourierDao courierDao;

    CourierLocationLogService(CourierLocationLogDao courierLocationLogDao, CourierDao courierRepository) {
        this.courierLocationLogDao = courierLocationLogDao;
        this.courierDao = courierRepository;
    }

    public void save(String courierId, LocationLogRequest locationLogRequest) {
        Courier courier = getCourierById(courierId);

        // TODO: do last minute check

        CourierLocationLog courierLocationLog = new CourierLocationLog();
        courierLocationLog.setCourier(courier);
        courierLocationLog.setLocation(new Point(locationLogRequest.getLatitude(), locationLogRequest.getLongitude()));
        courierLocationLog.setTime(new Date());

        courierLocationLogDao.save(courierLocationLog);
    }

    public List<CourierLocationLog> findByCourierId(String courierId) {
        Courier courier = getCourierById(courierId);

        return courierLocationLogDao.findByCourier(courier);
    }

    private Courier getCourierById(String courierId) {
        return courierDao.findById(courierId).get(); // TODO: handle empty case
    }
}