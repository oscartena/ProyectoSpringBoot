package com.example.proyectospringboot.mapper;

import com.example.proyectospringboot.dto.ConstructorDTO;
import com.example.proyectospringboot.entity.Constructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ConstructorMapper implements Function<Constructor, ConstructorDTO> {
    @Override
    public ConstructorDTO apply(Constructor constructor) {
        return new ConstructorDTO(constructor.getName(), constructor.getNationality());
    }
}
