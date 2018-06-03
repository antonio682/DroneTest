package com.drone.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HousingState {

    private String name;
    private double xCoordinate;
    private double yCoordinate;
    private int range;

}
