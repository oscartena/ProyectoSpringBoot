package com.example.proyectospringboot.projection;

import java.util.List;

public interface ConstructorDetails {
    Long getId();
    String getName();
    List<DriverDetails> getDrivers();
}
