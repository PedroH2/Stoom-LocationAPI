package com.stoom.locationApi.controller;

import com.stoom.locationApi.dto.LocationDTO;
import com.stoom.locationApi.entity.Location;
import com.stoom.locationApi.service.LocationService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/location")
public class LocationController {

    private LocationService locationService;

    private LocationController (LocationService locationService){
        this.locationService = locationService;
    }

    @PostMapping ("/post")
    public ResponseEntity<Void> post(@RequestBody LocationDTO dto) throws IOException {
        locationService.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping ("/get")
    public ResponseEntity<List<LocationDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(locationService.findAll());
    }

    @PutMapping ("/put/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody LocationDTO locationDTO){
        locationService.update(id, locationDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        locationService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}