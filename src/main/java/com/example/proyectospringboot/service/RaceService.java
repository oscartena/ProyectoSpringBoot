package com.example.proyectospringboot.service;

import com.example.proyectospringboot.entity.Race;
import com.example.proyectospringboot.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {
    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
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
