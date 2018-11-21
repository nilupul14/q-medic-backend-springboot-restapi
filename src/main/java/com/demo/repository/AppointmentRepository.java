package com.demo.repository;

import com.demo.model.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Long> {

    @Query("select a from Appointment a where a.isDeleted = false")
    List<Appointment> getAllAppointments();

    @Query("select a from Appointment a where a.appointmentId =:id and a.isDeleted = false")
    Appointment findAppointmentAppointmentById(@Param("id") int id);

}