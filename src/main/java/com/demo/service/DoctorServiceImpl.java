package com.demo.service;

import java.util.List;

//import com.demo.dao.DoctorDao;
import com.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{

	 @Autowired
	 private DoctorRepository doctorRepository;
	
	 @Override
	 public List<Doctor> getAllDoctors() {
	  return doctorRepository.getAllDoctors();
	 }

	 @Override
	 public Doctor findDoctorById(int id) {
	  return doctorRepository.findDoctorDoctorById(id);
	 }

	 @Override
	 public Doctor addDoctor(Doctor doctor) {
		 return doctorRepository.save(doctor);
	 }

	 @Override
	 public Doctor updateDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);

	 }

	 @Override
	 public void deleteDoctor(int id) {
 		 Doctor doctor = findDoctorById(id);
 		 doctor.setDeleted(true);
 		 doctorRepository.save(doctor);

	 }

}
