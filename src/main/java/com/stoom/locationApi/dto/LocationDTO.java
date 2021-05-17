package com.stoom.locationApi.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocationDTO {
    private String streetName;
    private Long number;
    private String complement;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String latitude;
    private String longitude;
}
