package com.demo.controller;

import com.demo.dto.CentreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Centre;
import com.demo.service.CentreServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("centre")
public class CentreController {

	@Autowired
	private CentreServiceImpl centreService;

//------------------------------------list all------------------------------------------------------------------

	@GetMapping("/list")
	 public List<Centre> getAllCentres() {
		List <Centre> list =  this.centreService.getAllCentres();
	  return list;
	 }

//------------------------------------one by one ------------------------------------------------------------------

	@GetMapping("/list/{centreId}")
	public Centre findCentreById(@PathVariable int centreId){
	 	return  centreService.findCentreById(centreId);
	}

//------------------------------------create------------------------------------------------------------------
	@PostMapping("/add")
	public String addCentre(@RequestBody CentreDTO centre){

		Centre cen = null;

		Centre ctr = new Centre();
		ctr.setName(centre.getName());
		ctr.setEmail(centre.getEmail());
		ctr.setPhone(centre.getPhone());
		ctr.setAddress(centre.getAddress());
		ctr.setCentreInfo(centre.getCentreInfo());
		cen = centreService.addCentre(ctr);

		return "Created Success..!";
	}

//------------------------------------update------------------------------------------------------------------

	@PutMapping("/edit")
	public Centre updateCentre(@RequestBody Centre centre) {

		return  centreService.updateCentre(centre);
	}

//------------------------------------delete------------------------------------------------------------------

	@CrossOrigin
	@GetMapping("/delete")
	public String deleteCentre(@RequestParam("centreId") int centreId) {
		centreService.deleteCentre(centreId);
		return "Delete Successfully";
	}

}
