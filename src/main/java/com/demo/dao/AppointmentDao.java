package com.demo.dao;

import java.util.List;

import com.demo.model.Appointment;

public interface AppointmentDao {

	 public List<Appointment> getAllAppointments();
	 
	 public Appointment findeAppointmentById(int id);
	 
	 public void addAppointment(Appointment appointment);
	 
	 public void updateAppointment(Appointment appointment);
	 
	 public void deleteAppointment(int id);
}
