package com.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DoctorRowMapper implements RowMapper<Doctor> {
	
	public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		  Doctor doctor = new Doctor();
		  doctor.setDoctorId(rs.getInt("doctor_id"));
		  doctor.setName(rs.getString("name"));
		  doctor.setDoctorType(rs.getString("doctor_type"));
		  doctor.setEmail(rs.getString("email"));
		  doctor.setPhone(rs.getString("phone"));
		  doctor.setDoctorInfo(rs.getString("doctor_info"));
		  return doctor;
		
	}

}
