package com.demo.dao;

import java.util.List;

import com.demo.model.Centre;

public interface CentreDao {

	 public List<Centre> getAllCentres();
	 
	 public Centre findeCentreById(int id);
	 
	 public void addCentre(Centre centre);
	 
	 public void updateCentre(Centre centre);
	 
	 public void deleteCentre(int id);
}
