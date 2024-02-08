package com.example.proyectospringboot.projection;

import org.springframework.beans.factory.annotation.Value;

public interface DriverDetails {
    Long getId();
    String getCode();
    @Value("#{target.forename + ' ' + target.surname}")
    String getFullname();

//    String getForename();
//    String getSurname();
//
//    default String getFullName(){
//        return getForename().concat(" ").concat(getSurname());
//    };
}
