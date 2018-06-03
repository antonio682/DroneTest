package com.drone.service;

import com.drone.dto.HousingStateResponse;

import java.util.List;

public interface DroneService {

    List<HousingStateResponse> obtainAllHousingStateResponseByRange(double coordinateX, double coordinateY, int range) throws Exception;
}
