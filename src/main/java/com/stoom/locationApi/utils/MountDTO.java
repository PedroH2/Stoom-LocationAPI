package com.stoom.locationApi.utils;

import com.stoom.locationApi.dto.LocationDTO;
import com.stoom.locationApi.entity.Location;
import lombok.Builder;
import lombok.Getter;

public class MountDTO {

    public static LocationDTO toDTO(Location location){
        LocationDTO dto = LocationDTO.builder()
                .streetName(location.getStreetName())
                .number(location.getNumber())
                .complement(location.getComplement())
                .neighbourhood(location.getNeighbourhood())
                .city(location.getCity())
                .state(location.getState())
                .country(location.getCountry())
                .zipCode(location.getZipCode())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
        return  dto;
    }
}
