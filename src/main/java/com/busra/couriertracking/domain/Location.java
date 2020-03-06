package com.busra.couriertracking.domain;

import com.mongodb.client.model.geojson.Point;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "location")
public class Location {

    @Id
    private String id;

    private Point location;

    private Courier courier;

    // private Date time; ?

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}