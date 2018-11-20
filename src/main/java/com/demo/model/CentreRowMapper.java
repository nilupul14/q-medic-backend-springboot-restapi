package com.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CentreRowMapper implements RowMapper<Centre> {
	
	public Centre mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		  Centre centre = new Centre();
		  centre.setCentreId(rs.getInt("centre_id"));
		  centre.setName(rs.getString("name"));
		  centre.setAddress(rs.getString("address"));
		  centre.setEmail(rs.getString("email"));
		  centre.setPhone(rs.getString("phone"));
		  centre.setCentreInfo(rs.getString("centre_info"));
		  return centre;
		
	}

}


