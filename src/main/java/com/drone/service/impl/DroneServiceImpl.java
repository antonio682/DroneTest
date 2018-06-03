package com.drone.service.impl;

import com.drone.domain.HousingState;
import com.drone.repository.HousingStateRepository;
import com.drone.dto.HousingStateResponse;
import com.drone.service.DroneService;
import com.drone.util.BeansFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DroneServiceImpl implements DroneService{


    private HousingStateRepository housingStateRepository;

    public DroneServiceImpl() {
       this.housingStateRepository = BeansFactory.createHousingStateRepository();
    }

    @Override
    public List<HousingStateResponse> obtainAllHousingStateResponseByRange(double coordinateX, double coordinateY,
                                                                           int range) {
        Optional<HousingState> origin = obtainOrigin(coordinateX, coordinateY);

        List<HousingStateResponse> response = getHousingStatesToVisit(range);

        origin.ifPresent(housingState -> response.add(createHousingResponse(housingState)));

        return response;
    }


    private Optional<HousingState> obtainOrigin(double coordinateX, double coordinateY) {
        return housingStateRepository.findAll().stream()
                .filter(housingState -> housingState.getXCoordinate() == coordinateX
                        && housingState.getYCoordinate() == coordinateY)
                .findFirst();
    }

    private List<HousingStateResponse> getHousingStatesToVisit(int range) {
        return housingStateRepository.findAll().stream()
                .filter(housingState -> housingState.getRange() == range)
                .map(this::createHousingResponse)
                .collect(Collectors.toList());
    }

    private HousingStateResponse createHousingResponse(HousingState housingState) {
        return HousingStateResponse.builder()
                .name(housingState.getName())
                .range(housingState.getRange())
                .build();
    }
}
