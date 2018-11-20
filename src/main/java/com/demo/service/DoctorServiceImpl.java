package com.demo.service;

import java.util.List;

import com.demo.dao.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{

	 @Autowired
	 private DoctorDao doctorDao;

//	 @Autowired
//	 private DoctorRepository doctorRepository;
	
	 @Override
	 public List<Doctor> getAllDoctors() {
	  return doctorDao.getAllDoctors();
	 }

	 @Override
	 public Doctor findDoctorById(int id) {
	  return doctorDao.findeDoctorById(id);
	 }

	 @Override
	 public Doctor addDoctor(Doctor doctor) {
		 doctorDao.addDoctor(doctor);
		 return doctor;
	 }

	 @Override
	 public void updateDoctor(Doctor doctor) {
		 doctorDao.updateDoctor(doctor);
	 }

	 @Override
	 public void deleteDoctor(int id) {
		 doctorDao.deleteDoctor(id);
	 }

//	 @Override
//	 public Doctor addDoctor(String name, String doctorType, String email, String phone, String doctorInfo, byte[] image) {
//
//
//		Doctor doctor = new Doctor();
//		doctor.setName(name);
//		doctor.setEmail(email);
//		doctor.setPhone(phone);
//		doctor.setDoctorType(doctorType);
//		doctor.setDoctorInfo(doctorInfo);
//		doctor.setImage(image);
//
//		return doctorRepository.save(doctor);
//	 }


}
