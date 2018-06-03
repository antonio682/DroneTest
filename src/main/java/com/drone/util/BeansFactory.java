package com.drone.util;

import com.drone.repository.HousingStateRepository;
import com.drone.repository.impl.HousingStateRepositoryImpl;
import com.drone.service.DroneService;
import com.drone.service.impl.DroneServiceImpl;

public class BeansFactory {

    private BeansFactory() {
    }

    public static HousingStateRepository createHousingStateRepository() {
      return new HousingStateRepositoryImpl();
    }

    public static DroneService createDroneService() {
        return new DroneServiceImpl();
    }
}
