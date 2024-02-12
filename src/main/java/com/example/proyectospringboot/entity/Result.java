package com.example.proyectospringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultid")
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "raceid")
    @JsonManagedReference
    private Race race;

    @ManyToOne
    @JoinColumn(name = "driverid")
    @JsonManagedReference
    private Driver driver;

    @Column(name = "grid", nullable = false)
    private int grid;
    @Column(name = "position")
    private Integer position;
    @Column(name = "points", nullable = false)
    private int points;

}
