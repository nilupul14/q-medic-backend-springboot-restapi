package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.AppointmentDaoImpl;
import com.demo.model.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	 @Autowired
	 private AppointmentDaoImpl appointmentDao;
	
	 @Override
	 public List<Appointment> getAllAppointments() {
	  return appointmentDao.getAllAppointments();
	 }

	 @Override
	 public Appointment findAppointmentById(int id) {
	  return appointmentDao.findeAppointmentById(id);
	 }

	 @Override
	 public Appointment addAppointment(Appointment appointment) {
		 appointmentDao.addAppointment(appointment);
		 return appointment;
	 }

	 @Override
	 public void updateAppointment(Appointment appointment) {
		 appointmentDao.updateAppointment(appointment);
	 }

	 @Override
	 public void deleteAppointment(int id) {
		 appointmentDao.deleteAppointment(id);
	 }
}
