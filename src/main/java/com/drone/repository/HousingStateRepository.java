package com.drone.repository;

import com.drone.domain.HousingState;

import java.util.List;

public interface HousingStateRepository {

    List<HousingState> findAll();
}
