package com.example.proyectospringboot.service;

import com.example.proyectospringboot.entity.Circuit;
import com.example.proyectospringboot.repository.CircuitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitService {
    private final CircuitRepository circuitRepository;

    public CircuitService(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }

    public List<Circuit> getAllCircuits() {
        return circuitRepository.findAll();
    }

    public Optional<Circuit> getCircuitByCircuitRef(String circuitRef) {
        return circuitRepository.findByCircuitRefIgnoreCase(circuitRef);
    }

    public void saveCircuit(Circuit circuit) {
        circuitRepository.save(circuit);
    }

    public void deleteCircuitByCircuitRef(String circuitRef) {
        circuitRepository.deleteByCircuitRefIgnoreCase(circuitRef);
    }
}
