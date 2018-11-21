//package com.demo.controller;
//
//import com.demo.model.Location;
//import com.demo.service.LocationServiceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.List;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("location")
//public class LocationController {
//
//    @Autowired
//    private LocationServiceImpl locationService;
//
//    @GetMapping("/list")
//    public List<Location> getAllLocations() {
//        java.util.List<Location> list = locationService.getAllLocations();
//        return list;
//    }
//
//    @GetMapping("/list/{locationId}")
//    public Location findLocationById(@PathVariable int locationId) {
//        return locationService.findLocationById(locationId);
//    }
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    @PostMapping("/add")
//    public ResponseEntity<Void> addLocation(@RequestBody Location newLocation, UriComponentsBuilder builder){
//        Location location = locationService.addLocation(newLocation);
//
//        if(location == null) {
//            return ResponseEntity.noContent().build();
//        }
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/location/{id}").buildAndExpand(location.getLocationId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    @PutMapping("/edit/")
//    public ResponseEntity<Location> updateLocation(@RequestBody Location location){
//
//        Location loc = locationService.findLocationById(location.getLocationId());
//
//        if(loc == null) {
//            return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
//        }
//
//        loc.setLocationName(location.getLocationName());
//        loc.setLatitude(location.getLatitude());
//        loc.setLongitude(location.getLongitude());
//
//        locationService.updateLocation(loc);
//        return new ResponseEntity<Location>(loc, HttpStatus.OK);
//    }
//
////////////////////////////////////////////////////////////////////////////////////////////////
//
//    @DeleteMapping("/delete/{locationId}")
//    public ResponseEntity<Location> deleteLocation(@PathVariable int locationId){
//        Location loc = locationService.findLocationById(locationId);
//
//        if(loc == null) {
//            return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
//        }
//
//        locationService.deleteLocation(locationId);
//        return new ResponseEntity<Location>(HttpStatus.NO_CONTENT);
//    }
//}
