package com.demo.repository;

import com.demo.model.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentreRepository extends JpaRepository<Centre,Long> {

    @Query("select c from Centre c where c.isDeleted = false")
    List<Centre> getAllCentres();

    @Query("select c from Centre c where c.centreId =:id and c.isDeleted = false")
    Centre findCentreCentreById(@Param("id") int id);

//    Centre deleteByCentreId(int id);
}
