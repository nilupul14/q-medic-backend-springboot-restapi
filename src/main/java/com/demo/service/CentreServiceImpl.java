package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CentreDaoImpl;
import com.demo.model.Centre;

@Service
public class CentreServiceImpl implements CentreService {

	@Autowired
	private CentreDaoImpl centreDao;
	
	 @Override
	 public List<Centre> getAllCentres() {
	  return centreDao.getAllCentres();
	 }

	 @Override
	 public Centre findCentreById(int id) {
	  return centreDao.findeCentreById(id);
	 }

	 @Override
	 public Centre addCentre(Centre centre) {
		 centreDao.addCentre(centre);
		 return centre;
	 }

	 @Override
	 public void updateCentre(Centre centre) {
		 centreDao.updateCentre(centre);
	 }

	 @Override
	 public void deleteCentre(int id) {
		 centreDao.deleteCentre(id);
	 }
}
