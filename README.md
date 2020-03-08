# Courier-Tracking REST API

This API logs couriers' instant locations and entrances to specific locations. Also provides individual couriers' total travel distance.

## Tech Stack

* Java 8
* Spring Boot 2.2
* Maven 3
* MongoDB 4.2

## Notes on Init

* To run application, you can use this command:

```
mvn spring-boot:run
```

* Before running the application, you should create a DB called "courier-tracking" on local MongoDB server.

* On application init, sample store locations and sample couriers are created.

## Endpoints

* Lists couriers

```
GET /courier
```

* Creates courier location log

```
POST /courier/{courierId}/location-log

{
  "latitude": 40.992913,
  "longitude": 29.122722,
  "time": "2020-03-07T21:31:29.206Z"
}
```

* Lists courier's location logs

```
GET /courier/{courierId}/location-log?pageNumber=0
```

* Gets courier's total travel distance in kilometers

```
GET /courier/{courierId}/total-travel-distance
```