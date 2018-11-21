package com.demo.repository;

import com.demo.model.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long>{

    @Query("select d from Doctor d where d.isDeleted = false")
    List<Doctor> getAllDoctors();

    @Query("select d from Doctor d where d.doctorId =:id and d.isDeleted = false")
    Doctor findDoctorDoctorById(@Param("id") int id);

}
