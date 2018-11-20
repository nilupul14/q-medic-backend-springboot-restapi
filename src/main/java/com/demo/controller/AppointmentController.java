package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Appointment;
import com.demo.service.AppointmentServiceImpl;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentServiceImpl appointmentService;

	//---------------------Get List----------------------------
	@GetMapping("/list")
	public List<Appointment> getAllAppointments() {
		java.util.List<Appointment> list = appointmentService.getAllAppointments();
		return list;
	}
	//------------------Get------------------------------------
	@GetMapping("/list/{appointmentId}")
	public Appointment findAppointmentById(@PathVariable int appointmentId) {
		return appointmentService.findAppointmentById(appointmentId);
	}

	//---------------------Create------------------------------------
	@PostMapping("/add")
	public ResponseEntity<Void> addCustomer(@RequestBody Appointment newAppointment, UriComponentsBuilder builder){
		Appointment appointment = appointmentService.addAppointment(newAppointment);

		if(appointment == null) {
			return ResponseEntity.noContent().build();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/appointment/{id}").buildAndExpand(appointment.getAppointmentId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	//------------------Update------------------------
	@PutMapping("/edit/")
	public ResponseEntity<Appointment> updateDoctor(@RequestBody Appointment appointment){

		Appointment app = appointmentService.findAppointmentById(appointment.getAppointmentId());

		if(app == null) {
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}

		app.setName(appointment.getName());
		app.setAge(appointment.getAge());
		app.setPhone(appointment.getPhone());
		app.setAddress(appointment.getAddress());
		app.setDoctor(appointment.getDoctor());

		appointmentService.updateAppointment(app);
		return new ResponseEntity<Appointment>(app, HttpStatus.OK);
	}

	//---------------------Delete-------------------------

	@DeleteMapping("/delete/{appointmentId}")
	public ResponseEntity<Appointment> deleteAppointment(@PathVariable int appointmentId){
		Appointment doc = appointmentService.findAppointmentById(appointmentId);

		if(doc == null) {
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}

		appointmentService.deleteAppointment(appointmentId);
		return new ResponseEntity<Appointment>(HttpStatus.NO_CONTENT);
	}

	//------------------Select doctor---------------
	@ModelAttribute("doctorList")
	public Map<String, String> getDoctor() {
		Map<String, String> doctorList = new HashMap<String, String>();
		doctorList.put("US", "Jone Doe");
		doctorList.put("CH", "Robin Peterson");
		doctorList.put("SG", "Alex Watson");
		doctorList.put("MY", "Smith Strack");
		return doctorList;
	}
}
