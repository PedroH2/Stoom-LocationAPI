package com.stoom.locationApi.business;

import com.stoom.locationApi.apiConsumer.GeoCodeObject;
import com.stoom.locationApi.apiConsumer.GeoCodeResult;
import com.stoom.locationApi.apiConsumer.GeocodeGeometry;
import com.stoom.locationApi.apiConsumer.GeocodeLocation;
import com.stoom.locationApi.controller.GeoCodeController;
import com.stoom.locationApi.dto.LocationDTO;
import com.stoom.locationApi.entity.Location;
import com.stoom.locationApi.error.ResourceNotFoundException;
import com.stoom.locationApi.repository.LocationRepository;
import com.stoom.locationApi.utils.MountDTO;
import com.stoom.locationApi.utils.MountEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LocationBusiness {

    private LocationRepository locationRepository;

    private LocationBusiness(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public void insert(Location entity) throws IOException {
        if (entity.getLatitude() == null || entity.getLongitude() == null) {
            String latitude = "";
            String longitude = "";
            GeoCodeResult geocode = new GeoCodeController().getGeocode(entity.getNumber().toString()
                                                                            + entity.getStreetName()
                                                                            + entity.getNeighbourhood()
                                                                            + entity.getState()
                                                                            + entity.getZipCode());
            List<GeoCodeObject> results = geocode.getResults();
            for (GeoCodeObject g : results) {
                GeocodeGeometry geometry = g.getGeometry();
                latitude = geometry.getGeocodeLocation().getLatitude();
                longitude = geometry.getGeocodeLocation().getLatitude();
            }
            entity.setLatitude(latitude);
            entity.setLongitude(longitude);
        }
        locationRepository.save(entity);
    }

    public List<LocationDTO> findAll() {
        List<Location> all = locationRepository.findAll();
        List<LocationDTO> dtoList = new ArrayList<>();
        for(Location l : all){
            dtoList.add(MountDTO.toDTO(l));
        }
        if(dtoList.isEmpty())
            throw new ResourceNotFoundException("No address found");
    return dtoList;
    }

    public void update(Long id, LocationDTO locationDTO) {
        Optional<Location> byId = locationRepository.findById(id);
        if(byId.isPresent()){
            Location location = MountEntity.toEntity(locationDTO);
            location.setId(id);
            locationRepository.save(location);
        }else{
            throw new ResourceNotFoundException("No address found with mentioned ID");
        }
    }

    public void delete(Long id) {
        Optional<Location> byId = locationRepository.findById(id);
        if(byId.isPresent()){
            locationRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No address found with mentioned ID");
        }
    }
}
