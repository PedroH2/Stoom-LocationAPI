package com.stoom.locationApi.apiConsumer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GeocodeLocation {

    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("lng")
    private String longitude;
}
