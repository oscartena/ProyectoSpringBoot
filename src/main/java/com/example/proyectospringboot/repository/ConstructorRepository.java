package com.example.proyectospringboot.repository;

import com.example.proyectospringboot.dto.ConstructorDTO;
import com.example.proyectospringboot.entity.Constructor;
import com.example.proyectospringboot.projection.ConstructorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {

    Optional<ConstructorDetails> findByConstructorRefIgnoreCase(String constructorRef);

    void deleteByConstructorRef(String constructorRef);
}
