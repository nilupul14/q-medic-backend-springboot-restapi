package com.demo.repository;

import com.demo.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long>{

    @Override
    List<Doctor> findAll();
}
