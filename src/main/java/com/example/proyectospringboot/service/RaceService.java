package com.example.proyectospringboot.service;

import com.example.proyectospringboot.entity.Race;
import com.example.proyectospringboot.projection.RaceProjection;
import com.example.proyectospringboot.repository.RaceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {
    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<RaceProjection> getAllRacesProjection() {
        return raceRepository.findAllProjectedBy();
    }

    public Page<Race> getAllRacesPaged(int page, int size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        PageRequest pageable = PageRequest.of(page, size, sort);
        return raceRepository.findAll(pageable);
    }

    public Optional<Race> getRaceByRound(int round) {
        return raceRepository.findByRound(round);
    }

    public void saveRace(Race race){
        raceRepository.save(race);
    }

    public void deleteRaceByRound(int round) {
        raceRepository.deleteByRound(round);
    }

}
