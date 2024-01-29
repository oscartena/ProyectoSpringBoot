package com.example.proyectospringboot.repository;

import com.example.proyectospringboot.model.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {
    Optional<Constructor> findByConstructorRefIgnoreCase(String constructorRef);

    void deleteByConstructorRef(String constructorRef);
}
