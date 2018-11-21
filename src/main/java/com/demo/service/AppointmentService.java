package com.demo.service;

import java.util.List;

import com.demo.model.Appointment;

public interface AppointmentService {

	 public List<Appointment> getAllAppointments();
	 
	 public Appointment findAppointmentById(int id);
	 
	 public Appointment addAppointment(Appointment appointment);
	 
	 public Appointment updateAppointment(Appointment appointment);
	 
	 public void deleteAppointment(int id);
}
