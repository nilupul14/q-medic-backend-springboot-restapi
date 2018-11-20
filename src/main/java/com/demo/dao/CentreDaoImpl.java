package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Centre;
import com.demo.model.CentreRowMapper;

@Transactional
@Repository
public class CentreDaoImpl implements CentreDao {

	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	 @Override
	 public List<Centre> getAllCentres() {
	  String query = "SELECT * from centres";
	  RowMapper<Centre> rowMapper = new CentreRowMapper();
	  List<Centre> list = jdbcTemplate.query(query, rowMapper);
	  
	  return list;
	 }

	 @Override
	 public Centre findeCentreById(int id) {
	  String query = "SELECT * FROM centres WHERE centre_id = ?";
	  RowMapper<Centre> rowMapper = new BeanPropertyRowMapper<Centre>(Centre.class);
	  Centre centre = jdbcTemplate.queryForObject(query, rowMapper, id);
	  
	  return centre;
	 }

	 @Override
	 public void addCentre(Centre centre) {
	  String query = "INSERT INTO centres(centre_id, name, address, email, phone, centre_info) VALUES(?, ?, ?, ?, ?, ?)";
	  jdbcTemplate.update(query, centre.getCentreId(), centre.getName(), centre.getAddress(), centre.getEmail(), centre.getPhone(), centre.getCentreInfo());
	  
	 }

	 @Override
	 public void updateCentre(Centre centre) {
	  String query = "UPDATE centres SET name=?, address=?, email=?, phone=?, centre_info=? WHERE centre_id=?";
	  jdbcTemplate.update(query, centre.getName(), centre.getAddress(), centre.getEmail(), centre.getPhone(), centre.getCentreInfo(), centre.getCentreId());
	  
	 }

	 @Override
	 public void deleteCentre(int id) {
	  String query = "DELETE FROM centres WHERE centre_id=?";
	  jdbcTemplate.update(query, id);
	 }
}
