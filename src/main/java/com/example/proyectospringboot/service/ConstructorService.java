package com.example.proyectospringboot.service;

import com.example.proyectospringboot.entity.Constructor;
import com.example.proyectospringboot.repository.ConstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorService {
    private final ConstructorRepository constructorRepository;

    public ConstructorService(ConstructorRepository constructorRepository) {
        this.constructorRepository = constructorRepository;
    }

    public List<Constructor> getAllConstructors() {
        return constructorRepository.findAll();
    }

    public Optional<Constructor> getConstructorByConstructorRef(String constructorRef) {
        return constructorRepository.findByConstructorRefIgnoreCase(constructorRef);
    }

    public void saveConstructor(Constructor constructor) {
        constructorRepository.save(constructor);
    }

    public void deleteConstructorByConstructorRef(String constructorRef) {
        constructorRepository.deleteByConstructorRef(constructorRef);
    }
}
