package com.example.proyectospringboot.dto;

public record DriverListDetailsDTO(
        Long id,
        String code,
        String fullname,
        String nationality,
        String constructor
) { }
