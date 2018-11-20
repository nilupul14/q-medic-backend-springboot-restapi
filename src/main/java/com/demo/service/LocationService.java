package com.demo.service;

import com.demo.model.*;

import java.util.List;

public interface LocationService {

    public List<Location> getAllLocations();

    public Location findLocationById(int id);

    public Location addLocation(Location location);

    public void updateLocation(Location location);

    public void deleteLocation(int id);
}

