package com.example.proyectospringboot.service;

import com.example.proyectospringboot.dto.DriverListDetailsDTO;
import com.example.proyectospringboot.entity.Driver;
import com.example.proyectospringboot.mapper.DriverMapper;
import com.example.proyectospringboot.projection.DriverDetailsDTO;
import com.example.proyectospringboot.repository.DriverRepository;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }
    @Override
    public List<DriverListDetailsDTO> getAllDrivers() {
        return driverRepository.findAll().stream().map(driverMapper).toList();
    }

    @Override
    public Page getAllDriversPaged(int page, int size, String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public Optional<DriverDetailsDTO> getDriverByCode(String code) {
        return driverRepository.findByCodeIgnoreCase(code);
    }

    @Override
    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public void deleteDriverByCode(String code) {
        driverRepository.deleteByCode(code);
    }
}
