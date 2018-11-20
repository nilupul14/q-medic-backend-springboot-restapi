package com.demo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper<Location> {

    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {

        Location location = new Location();
        location.setLocationId(rs.getInt("location_id"));
        location.setLocationName(rs.getString("location_name"));
        location.setLatitude(rs.getDouble("latitude"));
        location.setLongitude(rs.getDouble("longitude"));

        return location;

    }

}
