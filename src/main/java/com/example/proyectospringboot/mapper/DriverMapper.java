package com.example.proyectospringboot.mapper;

import com.example.proyectospringboot.dto.DriverDTO;
import com.example.proyectospringboot.entity.Driver;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface DriverMapper {
    @Mappings({
            @Mapping(target = "code", source = "code"),
            @Mapping(target = "fullName", expression = "java(crearFullName(driver.getForename(), driver.getSurname()))"),
            @Mapping(target = "dob", source = "dob")
    })
    DriverDTO fromDriverToDriverDTO(Driver driver);
}
