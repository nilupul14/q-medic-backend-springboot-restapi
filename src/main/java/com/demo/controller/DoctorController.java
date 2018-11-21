package com.demo.controller;

import com.demo.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.model.Doctor;
import com.demo.service.DoctorServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

//------------------------------------list all------------------------------------------------------------------
    @GetMapping("/list")
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = doctorService.getAllDoctors();
        return list;
    }
//------------------------------------one by one ------------------------------------------------------------------
    @GetMapping("/list/{doctorId}")
    public Doctor findDoctorById(@PathVariable int doctorId) {
        return doctorService.findDoctorById(doctorId);
    }

//------------------------------------create------------------------------------------------------------------

    @PostMapping("/add")
    public String addDoctor(@RequestBody DoctorDTO doctor){
//        byte[] image = new byte[0];
//
//        try {
//            byte[] name = Base64.getEncoder().encode(doctor.getImage().getBytes());
//            image = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
//            System.out.println(new String(image));
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        Doctor doc = null;

        Doctor dtr = new Doctor();
        dtr.setDoctorType(doctor.getDoctorType());
        dtr.setDoctorInfo(doctor.getDoctorInfo());
        dtr.setPhone(doctor.getPhone());
        dtr.setEmail(doctor.getEmail());
        dtr.setName(doctor.getName());
//        if(image.length != 0){
//            dtr.setImage(image);
//        }
        doc = doctorService.addDoctor(dtr);

//        return doctor.getName();
        return "Created Doctor";
    }

//------------------------------------update------------------------------------------------------------------

    @PutMapping("/edit")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {

        return  doctorService.updateDoctor(doctor);
    }

//------------------------------------delete------------------------------------------------------------------

    @CrossOrigin
    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam("doctorId")  int doctorId) {
        doctorService.deleteDoctor(doctorId);
        return "Delete Successfully";
    }
}
