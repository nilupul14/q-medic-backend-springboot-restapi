package com.demo.service;

import java.util.List;

import com.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	 @Autowired
	 private AppointmentRepository appointmentRepository;

	 @Override
     public List<Appointment> getAllAppointments() {
         return appointmentRepository.getAllAppointments();
     }

     @Override
     public Appointment findAppointmentById(int id) {
        return appointmentRepository.findAppointmentAppointmentById(id);
     }

	 @Override
	 public Appointment addAppointment(Appointment appointment) {
		 appointmentRepository.save(appointment);
		 return appointment;
	 }

	 @Override
	 public Appointment updateAppointment(Appointment appointment) {
		 return appointmentRepository.save(appointment);
	 }

     @Override
     public void deleteAppointment(int id) {
         Appointment appointment = findAppointmentById(id);
         appointment.setDeleted(true);
         appointmentRepository.save(appointment);
     }
}
