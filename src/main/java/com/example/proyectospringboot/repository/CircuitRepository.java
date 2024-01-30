package com.example.proyectospringboot.repository;

import com.example.proyectospringboot.entity.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CircuitRepository extends JpaRepository<Circuit, Long>{

    Optional<Circuit> findByCircuitRefIgnoreCase(String circuitRef);

    void deleteByCircuitRefIgnoreCase(String circuitRef);
}
