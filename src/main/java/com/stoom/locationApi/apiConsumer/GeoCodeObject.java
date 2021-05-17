package com.stoom.locationApi.apiConsumer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GeoCodeObject {
    @JsonProperty("place_id")
    String placeId;
    @JsonProperty("address_components")
    List<AddressComponent> addressComponents;
    @JsonProperty("formatted_address")
    String formattedAddress;
    GeocodeGeometry geometry;

}
