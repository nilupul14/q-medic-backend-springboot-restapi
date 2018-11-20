package com.demo.dao;

import com.demo.model.Location;

import java.util.List;

public interface LocationDao {

    public List<Location> getAllLocations();

    public Location findeLocationById(int id);

    public void addLocation(Location doctor);

    public void updateLocation(Location doctor);

    public void deleteLocation(int id);
}
