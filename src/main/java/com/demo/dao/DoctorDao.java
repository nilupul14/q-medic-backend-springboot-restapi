package com.demo.dao;

import java.util.List;

import com.demo.model.*;

public interface DoctorDao {

	 public List<Doctor> getAllDoctors();
	 
	 public Doctor findeDoctorById(int id);
	 
	 public void addDoctor(Doctor doctor);
	 
	 public void updateDoctor(Doctor doctor);
	 
	 public void deleteDoctor(int id);
}
