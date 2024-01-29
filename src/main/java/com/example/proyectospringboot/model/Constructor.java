package com.example.proyectospringboot.model;

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

    @Column(name = "constructorref", unique = true)
    private String constructorRef;

    @Column(unique = true)
    private String name;

    private String nationality;
    private String url;

    @OneToMany(mappedBy = "constructor" , cascade = CascadeType.ALL)
    @JsonIgnoreProperties("constructor")
    private List<Driver> drivers;
}
