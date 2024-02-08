package com.example.proyectospringboot.service;

import com.example.proyectospringboot.dto.DriverListDetailsDTO;
import com.example.proyectospringboot.entity.Driver;
import com.example.proyectospringboot.projection.DriverDetailsDTO;
import org.hibernate.query.Page;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<DriverListDetailsDTO> getAllDrivers();

    Optional<DriverDetailsDTO> getDriverByCode(String code);

    void saveDriver(Driver driver);

    void deleteDriverByCode(String code);


    Page getAllDriversPaged(int page, int size, String sortBy, String sortDirection);
}
