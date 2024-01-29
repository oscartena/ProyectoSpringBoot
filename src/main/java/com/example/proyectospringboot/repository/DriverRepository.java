package com.example.proyectospringboot.repository;

import com.example.proyectospringboot.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByCodeIgnoreCase(String code);

    void deleteByCode(String code);
}
