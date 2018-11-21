package com.demo.service;

import java.util.List;

import com.demo.model.*;
import org.springframework.web.multipart.MultipartFile;

public interface DoctorService {
	
	 public List<Doctor> getAllDoctors();
	 
	 public Doctor findDoctorById(int id);
	 
	 public Doctor addDoctor(Doctor doctor);
	 
	 public Doctor updateDoctor(Doctor doctor);
	 
	 public void deleteDoctor(int id);

}
