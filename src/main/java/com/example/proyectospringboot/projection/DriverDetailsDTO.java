package com.example.proyectospringboot.projection;

public record DriverDetailsDTO (
    Long id,
    String code,
    String forename,
    String surname,
    String constructor
)
{}
