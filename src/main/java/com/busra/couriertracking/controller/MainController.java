package com.busra.couriertracking.controller;


import com.busra.couriertracking.service.LocationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private LocationService locationService;

    MainController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/saveLocation")
    public void saveLocation() {
        locationService.saveLocation();
        System.out.println();
    }

}