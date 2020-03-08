package com.busra.couriertracking.bootstrap;

import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.domain.Store;
import com.busra.couriertracking.repository.CourierDao;
import com.busra.couriertracking.repository.CourierLocationLogDao;
import com.busra.couriertracking.repository.StoreDao;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

@Component
public class SampleDataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final CourierDao courierDao;

    private final StoreDao storeDao;

    private final CourierLocationLogDao courierLocationLogDao;

    SampleDataInitializer(CourierDao courierDao, StoreDao storeDao, CourierLocationLogDao courierLocationLogDao) {
        this.courierDao = courierDao;
        this.storeDao = storeDao;
        this.courierLocationLogDao = courierLocationLogDao;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Store store1 = new Store();
        store1.setId("STR1");
        store1.setName("Ataşehir MMM Migros");
        store1.setLocation(new Point(29.1244229, 40.9923307));
        storeDao.save(store1);

        Store store2 = new Store();
        store2.setId("STR2");
        store2.setName("Novada MMM Migros");
        store2.setLocation(new Point(29.1161293, 40.986106));
        storeDao.save(store2);

        Store store3 = new Store();
        store3.setId("STR3");
        store3.setName("Beylikdüzü 5M Migros");
        store3.setLocation(new Point(28.6552262, 41.0066851));
        storeDao.save(store3);

        Store store4 = new Store();
        store4.setId("STR4");
        store4.setName("Ortaköy MMM Migros");
        store4.setLocation(new Point(29.0210292, 41.055783));
        storeDao.save(store4);

        Store store5 = new Store();
        store5.setId("STR5");
        store5.setName("Caddebostan MMM Migros");
        store5.setLocation(new Point(29.0630908, 40.9632463));
        storeDao.save(store5);

        Courier courier1 = new Courier();
        courier1.setId("CR1");
        courier1.setName("Aylak Adam");
        courierDao.save(courier1);

        Courier courier2 = new Courier();
        courier2.setId("CR2");
        courier2.setName("Vecihi Hürkuş");
        courierDao.save(courier2);
    }

}
