package com.drone.repository.impl;

import com.drone.repository.HousingStateRepository;
import com.drone.domain.HousingState;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class HousingStateRepositoryImpl implements HousingStateRepository{


    @Override
    public List<HousingState> findAll() {

        ObjectMapper mapper = new ObjectMapper();

        List<HousingState> response = new ArrayList<>();

        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("housing_states.json").getFile());
            String data = FileUtils.readFileToString(file);

            response =  mapper.readValue(data,
                   new TypeReference<List<HousingState>>(){});

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
