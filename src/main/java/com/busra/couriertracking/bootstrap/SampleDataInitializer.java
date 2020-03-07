package com.busra.couriertracking.bootstrap;

import com.busra.couriertracking.domain.Courier;
import com.busra.couriertracking.domain.CourierLocationLog;
import com.busra.couriertracking.domain.Store;
import com.busra.couriertracking.repository.CourierDao;
import com.busra.couriertracking.repository.CourierLocationLogDao;
import com.busra.couriertracking.repository.StoreDao;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import java.util.Date;

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
        courier1.setName("Raif Efendi");
        courierDao.save(courier1);

        Courier courier2 = new Courier();
        courier2.setId("CR2");
        courier2.setName("Martin Eden");
        courierDao.save(courier2);

        CourierLocationLog courierLocationLog1 = new CourierLocationLog();
        courierLocationLog1.setId("CLOG1");
        courierLocationLog1.setCourier(courier1);
        courierLocationLog1.setLocation(new Point(29.1245230, 40.9923310));
        courierLocationLog1.setTime(new Date());
        courierLocationLogDao.save(courierLocationLog1);

        CourierLocationLog courierLocationLog2 = new CourierLocationLog();
        courierLocationLog2.setId("CLOG2");
        courierLocationLog2.setCourier(courier1);
        courierLocationLog2.setLocation(new Point(29.1264230, 40.9924310));
        courierLocationLog2.setTime(new Date());
        courierLocationLogDao.save(courierLocationLog2);

        CourierLocationLog courierLocationLog3 = new CourierLocationLog();
        courierLocationLog3.setId("CLOG3");
        courierLocationLog3.setCourier(courier1);
        courierLocationLog3.setLocation(new Point(29.1247230, 40.9925310));
        courierLocationLog3.setTime(new Date());
        courierLocationLogDao.save(courierLocationLog3);

        CourierLocationLog courierLocationLog4 = new CourierLocationLog();
        courierLocationLog4.setId("CLOG4");
        courierLocationLog4.setCourier(courier2);
        courierLocationLog4.setLocation(new Point(29.1248230, 40.9926310));
        courierLocationLog4.setTime(new Date());
        courierLocationLogDao.save(courierLocationLog4);

        CourierLocationLog courierLocationLog5 = new CourierLocationLog();
        courierLocationLog5.setId("CLOG5");
        courierLocationLog5.setCourier(courier2);
        courierLocationLog5.setLocation(new Point(29.1248231, 40.9926311));
        courierLocationLog5.setTime(new Date());
        courierLocationLogDao.save(courierLocationLog5);
    }

}
