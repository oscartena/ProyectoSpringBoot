package com.example.proyectospringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "constructors")
public class Constructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructorid")
    private Long constructorId;

    @Column(name = "constructorref", unique = true, nullable = false)
    private String constructorRef;

    @Column(unique = true)
    private String name;

    @Column
    private String nationality;
    private String url;

    @OneToMany(mappedBy = "constructor" , cascade = CascadeType.ALL)
    @JsonIgnoreProperties("constructor")
    private List<Driver> drivers;
}
