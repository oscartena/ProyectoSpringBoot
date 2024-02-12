package com.example.proyectospringboot.repository;

import com.example.proyectospringboot.entity.Race;
import com.example.proyectospringboot.projection.RaceProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {

    Optional<Race> findByRound(int round);
    void deleteByRound(int round);

    Page<Race> findAll(Pageable pageable);

    List<RaceProjection> findAllProjectedBy();
}
