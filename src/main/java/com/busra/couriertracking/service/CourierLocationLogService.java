package com.busra.couriertracking.service;

import com.busra.couriertracking.controller.model.LocationLogRequest;
import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.domain.CourierLocationLog;
import com.busra.couriertracking.domain.Store;
import com.busra.couriertracking.repository.CourierDao;
import com.busra.couriertracking.repository.CourierLocationLogDao;
import com.busra.couriertracking.repository.StoreDao;
import com.busra.couriertracking.util.DateUtils;
import com.busra.couriertracking.util.DistanceUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CourierLocationLogService {

    private static final int NEAR_STORE_DISTANCE_IN_METERS = 100;

    private static final int PAGE_SIZE = 20;

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

        Point courierCurrentLocation = new Point(locationLogRequest.getLongitude(), locationLogRequest.getLatitude());

        CourierLocationLog courierLocationLog = new CourierLocationLog();
        courierLocationLog.setCourier(courier);
        courierLocationLog.setLocation(courierCurrentLocation);
        courierLocationLog.setTime(locationLogRequest.getTime());

        Optional<Store> nearStoreOptional = storeDao.findByLocationNear(courierCurrentLocation, NEAR_STORE_DISTANCE_IN_METERS);
        if (nearStoreOptional.isPresent()) {
            Store currentNearStore = nearStoreOptional.get();
            courierLocationLog.setStore(currentNearStore);
            handleEntranceTime(locationLogRequest, courier, courierLocationLog, currentNearStore);
        }

        courierLocationLogDao.save(courierLocationLog);
    }

    private void handleEntranceTime(LocationLogRequest locationLogRequest, Courier courier, CourierLocationLog courierLocationLog, Store currentNearStore) {
        courierLocationLog.setEntranceTime(locationLogRequest.getTime());

        Optional<CourierLocationLog> lastLogRecordOptional = courierLocationLogDao.findByCourier(courier, PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "time"))).getContent().stream().findFirst();
        if (lastLogRecordOptional.isPresent()) {
            CourierLocationLog lastLogRecord = lastLogRecordOptional.get();

            if (isNewEntrance(currentNearStore, lastLogRecord)) {
                courierLocationLog.setEntranceTime(locationLogRequest.getTime());
            } else if (isReEntranceWithinOneMinute(locationLogRequest, currentNearStore, lastLogRecord)) {
                courierLocationLog.setEntranceTime(lastLogRecord.getEntranceTime());
            } else {
                courierLocationLog.setEntranceTime(null);
            }
        }
    }

    private boolean isNewEntrance(Store currentNearStore, CourierLocationLog lastLogRecord) {
        return Objects.isNull(lastLogRecord.getStore()) || !lastLogRecord.getStore().getId().equals(currentNearStore.getId());
    }

    private boolean isReEntranceWithinOneMinute(LocationLogRequest locationLogRequest, Store currentNearStore, CourierLocationLog lastLogRecord) {
        return lastLogRecord.getStore().getId().equals(currentNearStore.getId())
                && Objects.nonNull(lastLogRecord.getEntranceTime())
                && DateUtils.timeDifferenceInSeconds(lastLogRecord.getEntranceTime(), locationLogRequest.getTime()) <= 60;
    }

    public Page<CourierLocationLog> findByCourierId(String courierId, int pageNumber) {
        Courier courier = getCourierById(courierId);

        return courierLocationLogDao.findByCourier(courier, PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "time")));
    }

    public Distance getTotalTravelDistance(String courierId) {
        Courier courier = getCourierById(courierId);

        BigDecimal totalDistance = BigDecimal.ZERO;
        final AtomicInteger pageNumber = new AtomicInteger();
        Page<CourierLocationLog> page;
        Point previousLocation = null;
        do {
            page = courierLocationLogDao.findByCourier(courier, PageRequest.of(pageNumber.getAndIncrement(), PAGE_SIZE, Sort.by(Sort.Direction.ASC, "time")));

            Iterator<CourierLocationLog> iterator = page.getContent().iterator();
            if (Objects.isNull(previousLocation)) {
                previousLocation = iterator.next().getLocation();
            }
            while (iterator.hasNext()) {
                Point nextLocation = iterator.next().getLocation();
                totalDistance = totalDistance.add(BigDecimal.valueOf(DistanceUtils.calculateHaversineDistanceBetween(previousLocation, nextLocation).getValue()));
                previousLocation = nextLocation;
            }
        } while (page.hasNext());

        return new Distance(totalDistance.doubleValue(), Metrics.KILOMETERS);
    }

    private Courier getCourierById(String courierId) {
        return courierDao.findById(courierId).orElseThrow(() -> new RuntimeException("Courier not found"));
    }

}