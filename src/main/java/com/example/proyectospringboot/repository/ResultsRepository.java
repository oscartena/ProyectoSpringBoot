package com.example.proyectospringboot.repository;

import com.example.proyectospringboot.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultsRepository extends JpaRepository<Result, Long> {

}
