package com.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AppointmentRowMapper implements RowMapper<Appointment> {
	
	public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		  Appointment appointment = new Appointment();
		  appointment.setAppointmentId(rs.getInt("appointment_id"));
		  appointment.setName(rs.getString("name"));
		  appointment.setAge(rs.getString("age"));
		  appointment.setPhone(rs.getString("phone"));
		  appointment.setAddress(rs.getString("address"));
		  appointment.setDoctor(rs.getString("doctor"));
		  return appointment;
	}
}
