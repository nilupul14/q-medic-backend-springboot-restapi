package com.demo.service;

import java.util.List;

import com.demo.repository.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Centre;

@Service
public class CentreServiceImpl implements CentreService {

	@Autowired
	private CentreRepository centreRepository;

	 @Override
	 public List<Centre> getAllCentres() {
	  return centreRepository.getAllCentres();
	 }

	 @Override
	 public Centre findCentreById(int id) {
	  return centreRepository.findCentreCentreById(id);
	 }

	 @Override
	 public Centre addCentre(Centre centre) {
		 centreRepository.save(centre);
		 return centre;
	 }

	 @Override
	 public Centre updateCentre(Centre centre) {
		return centreRepository.save(centre);
	 }

	 @Override
	 public void deleteCentre(int id) {
		 Centre centre = findCentreById(id);
		 centre.setDeleted(true);
		 centreRepository.save(centre);
	 }
}
