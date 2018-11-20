package com.demo.controller;


//
//import java.awt.List;

import com.demo.repository.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Centre;
import com.demo.service.CentreServiceImpl;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("centre")
public class CentreController {

	@Autowired
	private CentreServiceImpl centreService;

	@Autowired
	private CentreRepository centreRepository;

	 @GetMapping("/list")
	 public List getAllCentres() {
	  //ModelAndView model = new ModelAndView( "Centre");
//	  java.util.List<Centre> list = centreService.getAllCentres();
		List centres =  this.centreRepository.findAll();
	  return centres;
	 }

	@GetMapping("/list/{centreId}")
	public Centre findCentreById(@PathVariable int centreId) {
		return centreService.findCentreById(centreId);
	}


//	@PostMapping("/add")
//	public ResponseEntity<Void> addCentre(@RequestBody Centre newCentre, UriComponentsBuilder builder){
//		Centre centre = centreService.addCentre(newCentre);
//
//		if(centre == null) {
//			return ResponseEntity.noContent().build();
//		}
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(builder.path("/centre/{id}").buildAndExpand(centre.getCentreId()).toUri());
//		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	}

	@PostMapping("/add")
	public String addCentre(@RequestBody Centre newCentre){
		this.centreRepository.save(newCentre);
		return "Successfully Saved Centre Details";
	}

	@PutMapping("/edit/")
	public ResponseEntity<Centre> updateCentre(@RequestBody Centre centre){

		Centre cen = centreService.findCentreById(centre.getCentreId());

		if(cen == null) {
			return new ResponseEntity<Centre>(HttpStatus.NOT_FOUND);
		}

		cen.setName(centre.getName());
		cen.setAddress(centre.getAddress());
		cen.setEmail(centre.getEmail());
		cen.setPhone(centre.getPhone());
		cen.setCentreInfo(centre.getCentreInfo());

		centreService.updateCentre(cen);
		return new ResponseEntity<Centre>(cen, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{centreId}")
	public ResponseEntity<Centre> deleteCentre(@PathVariable int centreId){
		Centre doc = centreService.findCentreById(centreId);

		if(doc == null) {
			return new ResponseEntity<Centre>(HttpStatus.NOT_FOUND);
		}

		centreService.deleteCentre(centreId);
		return new ResponseEntity<Centre>(HttpStatus.NO_CONTENT);
	}












	/*
	 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	 public ModelAndView editCentre(@PathVariable int id) {
	  ModelAndView model = new ModelAndView();
	  
	  Centre centre = centreService.findCentreById(id);
	  model.addObject("centreForm", centre);
	  
	  model.setViewName("centre_form");
	  return model;
	 }
	 
	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView addCentre() {
	  ModelAndView model = new ModelAndView();
	  
	  Centre centre = new Centre();
	  model.addObject("centreForm", centre);
	  
	  model.setViewName("centre_form");
	  return model;
	 }
	 
	 @RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView saveOrUpdate(@ModelAttribute("centreForm") Centre centre) { 
	  if(centre.getCentreId() != null) {
		  centreService.updateCentre(centre);
	  } else {
		  centreService.addCentre(centre);
	  }
	  
	  return new ModelAndView("redirect:/centre/list");
	 }
	 
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView deleteCentre(@PathVariable("id") int id) {
		 centreService.deleteCentre(id);
	  
	  return new ModelAndView("redirect:/centre/list");
	 }*/
}
