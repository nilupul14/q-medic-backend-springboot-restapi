package com.demo.service;

import com.demo.dao.LocationDaoImpl;
import com.demo.model.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationDaoImpl locationDao;

    @Override
    public List<Location> getAllLocations() {

        return locationDao.getAllLocations();
    }

    @Override
    public Location findLocationById(int id) {

        return locationDao.findeLocationById(id);
    }

    @Override
    public Location addLocation(Location location) {
        locationDao.addLocation(location);
        return location;
    }

    @Override
    public void updateLocation(Location location) {
        locationDao.updateLocation(location);
    }

    @Override
    public void deleteLocation(int id) {
        locationDao.deleteLocation(id);
    }
}