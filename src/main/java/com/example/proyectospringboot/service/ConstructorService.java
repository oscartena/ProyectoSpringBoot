package com.example.proyectospringboot.service;

import com.example.proyectospringboot.dto.ConstructorDTO;
import com.example.proyectospringboot.entity.Constructor;
import com.example.proyectospringboot.mapper.ConstructorMapper;
import com.example.proyectospringboot.projection.ConstructorDetails;
import com.example.proyectospringboot.repository.ConstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorService {
    private final ConstructorRepository constructorRepository;

    private final ConstructorMapper ConstructorMapper;

    public ConstructorService(ConstructorRepository constructorRepository, ConstructorMapper ConstructorMapper) {
        this.constructorRepository = constructorRepository;
        this.ConstructorMapper = ConstructorMapper;
    }

    public List<ConstructorDTO> getAllConstructors() {
        List<Constructor> constructors = constructorRepository.findAll();
        return constructors.stream().map(ConstructorMapper).toList();
    }

    public Optional<ConstructorDetails> getConstructorByConstructorRef(String constructorRef) {
        return constructorRepository.findByConstructorRefIgnoreCase(constructorRef);
    }

    public void saveConstructor(Constructor constructor) {
        constructorRepository.save(constructor);
    }

    public void deleteConstructorByConstructorRef(String constructorRef) {
        constructorRepository.deleteByConstructorRef(constructorRef);
    }
}
