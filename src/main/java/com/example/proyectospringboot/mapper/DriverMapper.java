package com.example.proyectospringboot.mapper;

import com.example.proyectospringboot.dto.DriverListDetailsDTO;
import com.example.proyectospringboot.entity.Driver;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DriverMapper implements Function<Driver, DriverListDetailsDTO> {
    @Override
    public DriverListDetailsDTO apply(Driver driver) {
        return new DriverListDetailsDTO(driver.getDriverId(),
                driver.getCode(),
                driver.getForename()+" "+driver.getSurname(),
                driver.getNationality(),
                driver.getConstructor().getName() != null ? driver.getConstructor().getName() : "No constructor");
    }
}
