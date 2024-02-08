package com.example.proyectospringboot.repository;

import com.example.proyectospringboot.dto.DriverListDetailsDTO;
import com.example.proyectospringboot.entity.Driver;
import com.example.proyectospringboot.projection.DriverDetails;
import com.example.proyectospringboot.projection.DriverDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query("SELECT d.driverId as id, d.code as code, d.forename as forename, d.surname as surname, d.constructor.name as constructor FROM Driver d")
    Optional<DriverDetailsDTO> findByCodeIgnoreCase(String code);

    void deleteByCode(String code);

    Page<DriverDetails> getAllByDriversPaged(int pageNo, int pageSize, String sortby, String sortDirection);

}
