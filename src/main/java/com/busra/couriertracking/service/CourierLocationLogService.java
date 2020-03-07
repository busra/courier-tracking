package com.busra.couriertracking.service;

import com.busra.couriertracking.controller.model.LocationLogRequest;
import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.domain.CourierLocationLog;
import com.busra.couriertracking.domain.Store;
import com.busra.couriertracking.repository.CourierDao;
import com.busra.couriertracking.repository.CourierLocationLogDao;
import com.busra.couriertracking.repository.StoreDao;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierLocationLogService {

    private static final int NEAR_STORE_DISTANCE_IN_METERS = 100;

    private final CourierLocationLogDao courierLocationLogDao;

    private final CourierDao courierDao;

    private final StoreDao storeDao;

    CourierLocationLogService(CourierLocationLogDao courierLocationLogDao, CourierDao courierRepository, StoreDao storeDao) {
        this.courierLocationLogDao = courierLocationLogDao;
        this.courierDao = courierRepository;
        this.storeDao = storeDao;
    }

    public void save(String courierId, LocationLogRequest locationLogRequest) {
        Courier courier = getCourierById(courierId);

        // TODO: do last minute check

        Point courierCurrentLocation = new Point(locationLogRequest.getLongitude(), locationLogRequest.getLatitude());

        List<Store> nearStores = storeDao.findByLocationNear(courierCurrentLocation, NEAR_STORE_DISTANCE_IN_METERS);
        if (nearStores.isEmpty()) {
            CourierLocationLog courierLocationLog = createCourierLocationLog(locationLogRequest, courier, courierCurrentLocation);
            courierLocationLogDao.save(courierLocationLog);
        } else {
            nearStores.forEach(eachNearStore -> {
                CourierLocationLog courierLocationLog = createCourierLocationLog(locationLogRequest, courier, courierCurrentLocation);
                courierLocationLog.setStore(eachNearStore);
                courierLocationLogDao.save(courierLocationLog);
            });
        }
    }

    private CourierLocationLog createCourierLocationLog(LocationLogRequest locationLogRequest, Courier courier, Point courierCurrentLocation) {
        CourierLocationLog courierLocationLog = new CourierLocationLog();
        courierLocationLog.setCourier(courier);
        courierLocationLog.setLocation(courierCurrentLocation);
        courierLocationLog.setTime(locationLogRequest.getTime());
        return courierLocationLog;
    }

    public List<CourierLocationLog> findByCourierId(String courierId) {
        Courier courier = getCourierById(courierId);

        return courierLocationLogDao.findByCourier(courier);
    }

    private Courier getCourierById(String courierId) {
        return courierDao.findById(courierId).get(); // TODO: handle empty case
    }

}