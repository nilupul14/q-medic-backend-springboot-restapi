package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.dto.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Appointment;
import com.demo.service.AppointmentServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("appointment")
public class AppointmentController {

	@Autowired
	private AppointmentServiceImpl appointmentService;

//------------------------------------list all------------------------------------------------------------------
	@GetMapping("/list")
	public List<Appointment> getAllAppointments() {
		List<Appointment> list = appointmentService.getAllAppointments();
		return list;
	}
//------------------------------------one by one ------------------------------------------------------------------
	@GetMapping("/list/{appointmentId}")
	public Appointment findAppointmentById(@PathVariable int appointmentId) {
		return appointmentService.findAppointmentById(appointmentId);
	}

//------------------------------------create------------------------------------------------------------------
    @PostMapping("/add")

    public String addCentre(@RequestBody AppointmentDTO appointment){

        Appointment app = null;

        Appointment apt = new Appointment();
        apt.setName(appointment.getName());
        apt.setAge(appointment.getAge());
        apt.setPhone(appointment.getPhone());
        apt.setAddress(appointment.getAddress());
        apt.setDoctor(appointment.getDoctor());
        app = appointmentService.addAppointment(apt);

        return "Created Success..!";
    }
//------------------------------------update------------------------------------------------------------------

    @PutMapping("/edit")
    public Appointment updateAppointment(@RequestBody Appointment appointment) {

        return  appointmentService.updateAppointment(appointment);
    }

//------------------------------------delete------------------------------------------------------------------

    @DeleteMapping("/delete/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return "Delete Successfully";
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
