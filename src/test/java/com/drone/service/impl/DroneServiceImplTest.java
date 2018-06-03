package com.drone.service.impl;

import com.drone.dto.HousingStateResponse;
import com.drone.service.DroneService;
import com.drone.util.BeansFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DroneServiceImplTest {

    private final double X_COORDINATE = 38.56889;
    private final double Y_COORDINATE = 40.51107;

    private DroneService droneService;

    public DroneServiceImplTest() {
        this.droneService = BeansFactory.createDroneService();
    }

    @Test
    public void  should_return_list_of_housing_states_range_1() throws Exception {
        // GIVEN
        final int range = 1;
        // WHEN
        List<HousingStateResponse> response =  droneService.obtainAllHousingStateResponseByRange(X_COORDINATE, Y_COORDINATE, range);
        // THEN
        response.forEach(houseState -> {
            Assert.assertTrue("Wrong range",houseState.getRange() == 0 || houseState.getRange() == range);
        });
    }

    @Test
    public void  should_return_list_of_housing_states_range2() throws Exception {
        // GIVEN
        final int range = 2;
        // WHEN
        List<HousingStateResponse> response =  droneService.obtainAllHousingStateResponseByRange(X_COORDINATE, Y_COORDINATE, range);
        // THEN
        response.forEach(houseState -> {
            Assert.assertTrue("Wrong range",houseState.getRange() == 0 || houseState.getRange() == range);
        });
    }

}