package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Appointment;
import com.demo.model.AppointmentRowMapper;

@Transactional
@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	 @Override
	 public List<Appointment> getAllAppointments() {
	  String query = "SELECT * from appointments";
	  RowMapper<Appointment> rowMapper = new AppointmentRowMapper();
	  List<Appointment> list = jdbcTemplate.query(query, rowMapper);
	  
	  return list;
	 }

	 @Override
	 public Appointment findeAppointmentById(int id) {
	  String query = "SELECT * FROM appointments WHERE appointment_id = ?";
	  RowMapper<Appointment> rowMapper = new BeanPropertyRowMapper<Appointment>(Appointment.class);
	  Appointment appointment = jdbcTemplate.queryForObject(query, rowMapper, id);
	  
	  return appointment;
	 }

	 @Override
	 public void addAppointment(Appointment appointment) {
	  String query = "INSERT INTO appointments(appointment_id, name, age, phone, address, doctor) VALUES(?, ?, ?, ?, ?, ?)";
	  jdbcTemplate.update(query, appointment.getAppointmentId(), appointment.getName(), appointment.getAge(), appointment.getPhone(),
			  appointment.getAddress(), appointment.getDoctor());
	  
	 }
	 

	 @Override
	 public void updateAppointment(Appointment appointment) {
		 
	  String query = "UPDATE appointments SET name=?, age=?, phone=?, address=?, doctor=? WHERE appointment_id=?";
	  jdbcTemplate.update(query, appointment.getName(), appointment.getAge(), appointment.getPhone(), appointment.getAddress(),
			  appointment.getDoctor(), appointment.getAppointmentId());
	  
	 }

	 @Override
	 public void deleteAppointment(int id) {
	  String query = "DELETE FROM appointments WHERE appointment_id=?";
	  jdbcTemplate.update(query, id);
	 }

}
