package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Doctor;
import com.demo.model.DoctorRowMapper;

@Transactional
@Repository
public class DoctorDaoImpl implements DoctorDao {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	 @Override
	 public List<Doctor> getAllDoctors() {
	  String query = "SELECT * from doctors";
	  RowMapper<Doctor> rowMapper = new DoctorRowMapper();
	  List<Doctor> list = jdbcTemplate.query(query, rowMapper);
	  
	  return list;
	 }

	 @Override
	 public Doctor findeDoctorById(int id) {
	  String query = "SELECT * FROM doctors WHERE doctor_id = ?";
	  RowMapper<Doctor> rowMapper = new BeanPropertyRowMapper<Doctor>(Doctor.class);
	  Doctor doctor = jdbcTemplate.queryForObject(query, rowMapper, id);
	  
	  return doctor;
	 }

	 @Override
	 public void addDoctor(Doctor doctor) {
	  String query = "INSERT INTO doctors(doctor_id, name, doctor_type, email, phone, doctor_info, image) VALUES(?, ?, ?, ?, ?, ?, ?)";
	  jdbcTemplate.update(query, doctor.getDoctorId(), doctor.getName(), doctor.getDoctorType(), doctor.getEmail(), doctor.getPhone(), doctor.getDoctorInfo(), doctor.getImage());
	  
	 }

	 @Override
	 public void updateDoctor(Doctor doctor) {
	  String query = "UPDATE doctors SET name=?, doctor_type=?, email=?, phone=?, doctor_info=? WHERE doctor_id=?";
	  jdbcTemplate.update(query, doctor.getName(), doctor.getDoctorType(), doctor.getEmail(), doctor.getPhone(), doctor.getDoctorInfo(), doctor.getDoctorId());
	  
	 }

	 @Override
	 public void deleteDoctor(int id) {
	  String query = "DELETE FROM doctors WHERE doctor_id=?";
	  jdbcTemplate.update(query, id);
	 }

}
