package com.demo.controller;

import com.demo.dto.DoctorDTO;
import com.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.model.Doctor;
import com.demo.service.DoctorServiceImpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/list")
    public List<Doctor> getAllDoctors() {
//        java.util.List<Doctor> list = doctorService.getAllDoctors();
        java.util.List<Doctor> list = doctorRepository.findAll();
        return list;
    }

    @GetMapping("/list/{doctorId}")
    public Doctor findDoctorById(@PathVariable int doctorId) {
        return doctorService.findDoctorById(doctorId);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    @PostMapping("/add")
//    public ResponseEntity<Void> addDoctor(@RequestParam String name, @RequestParam String doctorType,
//                                          @RequestParam String email, @RequestParam String phone,
//                                          @RequestParam String doctorInfo, @RequestParam MultipartFile image,
//                                          UriComponentsBuilder builder) throws IOException {
//        Doctor doc = null;
//
//        Doctor d = new Doctor();
//        d.setName(name);
//        d.setDoctorType(doctorType);
//        d.setDoctorInfo(doctorInfo);
//        d.setPhone(phone);
//        d.setEmail(email);
//        if(image != null){
//            d.setImage(image.getBytes());
//        }
//        doc = doctorService.addDoctor(d);
//
//        if (doc == null) {
//            return ResponseEntity.noContent().build();
//        }
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/doctor/{id}").buildAndExpand(10).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }


    @PostMapping("/add")
    public String addDoctor(@RequestBody DoctorDTO doctor){
        byte[] image = new byte[0];


        try {
            byte[] name = Base64.getEncoder().encode(doctor.getImage().getBytes());
            image = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
            System.out.println(new String(image));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Doctor doc = null;

        Doctor d = new Doctor();
        d.setName(doctor.getName());
        d.setDoctorType(doctor.getDoctorType());
        d.setDoctorInfo(doctor.getDoctorInfo());
        d.setPhone(doctor.getPhone());
        d.setEmail(doctor.getEmail());
        if(image.length != 0){
            d.setImage(image);
        }
        doc = doctorService.addDoctor(d);

        return doctor.getName();
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PutMapping("/edit/")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {

        Doctor doc = doctorService.findDoctorById(doctor.getDoctorId());

        if (doc == null) {
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }

        doc.setName(doctor.getName());
        doc.setDoctorType(doctor.getDoctorType());
        doc.setEmail(doctor.getEmail());
        doc.setPhone(doctor.getPhone());
        doc.setDoctorInfo(doctor.getDoctorInfo());

        doctorService.updateDoctor(doc);
        return new ResponseEntity<Doctor>(doc, HttpStatus.OK);
    }

//////////////////////////////////////////////////////////////////////////////////////////////

    @DeleteMapping("/delete/{doctorId}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable int doctorId) {
        Doctor doc = doctorService.findDoctorById(doctorId);

        if (doc == null) {
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }

        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<Doctor>(HttpStatus.NO_CONTENT);
    }
}
