package com.example.proyectospringboot.service;

import com.example.proyectospringboot.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> getAllDrivers();

    Optional<Driver> getDriverByCode(String code);

    void saveDriver(Driver driver);

    void deleteDriverByCode(String code);
}
