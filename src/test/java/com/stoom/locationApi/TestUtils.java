package com.stoom.locationApi;

import com.stoom.locationApi.dto.LocationDTO;

public class TestUtils {

    public static LocationDTO mountTestDTO(){
        LocationDTO dto = LocationDTO.builder()
                .streetName("Test paradise avenue")
                .number(42L)
                .complement("Here we love testing")
                .neighbourhood("Test Link")
                .city("Test town")
                .state("NG")
                .country("TestLand")
                .zipCode("100100111")
                .latitude("10101010")
                .longitude("10101010")
                .build();
        return  dto;
    }
}