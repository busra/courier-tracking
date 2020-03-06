package com.busra.couriertracking.service;

import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.domain.Location;
import com.busra.couriertracking.repository.CourierRepository;
import com.busra.couriertracking.repository.LocationRepository;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    private CourierRepository courierRepository;

    LocationServiceImpl(LocationRepository locationRepository, CourierRepository courierRepository) {
        this.locationRepository = locationRepository;
        this.courierRepository = courierRepository;
    }

    public void saveLocation() {
        try {
            Courier courier = new Courier();
            courier.setId("1");
            courier.setName("raif efendi");
            courierRepository.save(courier);

            Courier courier2 = new Courier();
            courier2.setId("2");
            courier2.setName("martin eden");
            courierRepository.save(courier2);

            Point refPoint = new Point(new Position(40.9923310, 29.1245230));
            Point refPoint2 = new Point(new Position(40.9924310, 29.1264230));
            Point refPoint3 = new Point(new Position(40.9925310, 29.1247230));
            Point refPoint4 = new Point(new Position(40.9926310, 29.1248230));
            Point refPoint5 = new Point(new Position(40.9926311, 29.1248231));

            Location location = new Location();
            location.setId("1");
            location.setCourier(courier);
            location.setLocation(refPoint);
            locationRepository.save(location);

            Location location2 = new Location();
            location2.setId("2");
            location2.setCourier(courier);
            location2.setLocation(refPoint2);
            locationRepository.save(location2);

            Location location3 = new Location();
            location3.setId("3");
            location3.setCourier(courier);
            location3.setLocation(refPoint3);
            locationRepository.save(location3);

            Location location4 = new Location();
            location4.setId("4");
            location4.setCourier(courier2);
            location4.setLocation(refPoint4);
            locationRepository.save(location4);

            Location location5 = new Location();
            location5.setId("5");
            location5.setCourier(courier2);
            location5.setLocation(refPoint5);
            locationRepository.save(location5);
        } catch (Exception e) {
            System.out.println("test");
        }
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

}