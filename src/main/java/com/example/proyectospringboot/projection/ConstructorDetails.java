package com.example.proyectospringboot.projection;

import java.util.List;

public interface ConstructorDetails {
    String getId();
    String getName();
    List<DriverDetails> getDrivers();
}
