package com.busra.couriertracking.util;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

public final class DistanceUtils {

    private static final int EARTH_RADIUS_IN_KILOMETERS = 6371;

    private DistanceUtils() {
    }

    /**
     * https://en.wikipedia.org/wiki/Haversine_formula
     */
    public static Distance calculateHaversineDistanceBetween(Point firstLocation, Point secondLocation) {
        double latitudeDifference = Math.toRadians(secondLocation.getY() - firstLocation.getY());
        double longitudeDifference = Math.toRadians(secondLocation.getX() - firstLocation.getX());
        double sindLat = Math.sin(latitudeDifference / 2);
        double sindLng = Math.sin(longitudeDifference / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(Math.toRadians(firstLocation.getY())) * Math.cos(Math.toRadians(secondLocation.getY()));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS_IN_KILOMETERS * c;

        return new Distance(distance, Metrics.KILOMETERS);
    }

}