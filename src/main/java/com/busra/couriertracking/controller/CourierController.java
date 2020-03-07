package com.busra.couriertracking.controller;

import com.busra.couriertracking.controller.model.LocationLogRequest;
import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.domain.CourierLocationLog;
import com.busra.couriertracking.service.CourierLocationLogService;
import com.busra.couriertracking.service.CourierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courier")
public class CourierController {

    private final CourierLocationLogService courierLocationLogService;

    private final CourierService courierService;

    CourierController(CourierLocationLogService courierLocationLogService, CourierService courierService) {
        this.courierLocationLogService = courierLocationLogService;
        this.courierService = courierService;
    }

    @GetMapping
    public List<Courier> getCouriers() {
        return courierService.findAll();
    }

    @PostMapping("/{courierId}/location-log")
    public void saveLocationLog(@PathVariable String courierId, @RequestBody LocationLogRequest locationLogRequest) {
        courierLocationLogService.save(courierId, locationLogRequest);
    }

    @GetMapping("/{courierId}/location-log")
    public List<CourierLocationLog> getLocationLogsOfCourier(@PathVariable String courierId) {
        return courierLocationLogService.findByCourierId(courierId);
    }
}