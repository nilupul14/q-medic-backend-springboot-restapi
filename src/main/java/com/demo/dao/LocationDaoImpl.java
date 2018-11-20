package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Location;
import com.demo.model.LocationRowMapper;

import java.util.List;

@Transactional
@Repository
public class LocationDaoImpl implements LocationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<com.demo.model.Location> getAllLocations() {
        String query = "SELECT * from locations";
        LocationRowMapper rowMapper = new LocationRowMapper();
        List<Location> list = jdbcTemplate.query(query, rowMapper);

        return list;
    }

    @Override
    public Location findeLocationById(int id) {
        String query = "SELECT * FROM locations WHERE location_id = ?";
        RowMapper<Location> rowMapper = new BeanPropertyRowMapper<Location>(Location.class);
        Location location = jdbcTemplate.queryForObject(query, rowMapper, id);

        return location;
    }

    @Override
    public void addLocation(Location location) {
        String query = "INSERT INTO locations(location_id, location_name, latitude, longitude) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(query, location.getLocationId(), location.getLocationName(), location.getLatitude(), location.getLongitude());

    }

    @Override
    public void updateLocation(Location location) {
        String query = "UPDATE locations SET location_name=?, latitude=?, longitude=? WHERE location_id=?";
        jdbcTemplate.update(query, location.getLocationName(), location.getLatitude(), location.getLongitude(), location.getLocationId());

    }

    @Override
    public void deleteLocation(int id) {
        String query = "DELETE FROM locations WHERE location_id=?";
        jdbcTemplate.update(query, id);
    }
}