package com.stoom.locationApi.service;

import com.stoom.locationApi.business.LocationBusiness;
import com.stoom.locationApi.dto.LocationDTO;
import com.stoom.locationApi.entity.Location;
import com.stoom.locationApi.utils.MountDTO;
import com.stoom.locationApi.utils.MountEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LocationService {

    private LocationBusiness locationBusiness;

    private LocationService(LocationBusiness locationBusiness){
        this.locationBusiness = locationBusiness;
    }
    public void insert(LocationDTO dto) throws IOException {
        Location location = mountEntity(dto);
        locationBusiness.insert(location);
    }
    public Location mountEntity(LocationDTO dto){
        return MountEntity.toEntity(dto);
    }

    public List<LocationDTO> findAll() {
        return locationBusiness.findAll();
    }

    public void update(Long id, LocationDTO locationDTO) {
        locationBusiness.update(id, locationDTO);
    }
    public void delete(Long id) {
        locationBusiness.delete(id);
    }
}
