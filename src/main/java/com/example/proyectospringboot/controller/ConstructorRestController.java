package com.example.proyectospringboot.controller;

import com.example.proyectospringboot.dto.ConstructorDTO;
import com.example.proyectospringboot.entity.Constructor;
import com.example.proyectospringboot.projection.ConstructorDetails;
import com.example.proyectospringboot.service.ConstructorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConstructorRestController {

    private final ConstructorService constructorService;

    @Autowired
    public ConstructorRestController(ConstructorService constructorService){
        this.constructorService = constructorService;
    }

    @GetMapping("/constructors")
    public ResponseEntity<List<ConstructorDTO>> getAll(){
        return ResponseEntity.ok(constructorService.getAllConstructors());
    }

    @GetMapping("/constructors/{constructorRef}")
    public ResponseEntity<ConstructorDetails> getByConstructorRef(@PathVariable String constructorRef){
        return this.constructorService.getConstructorByConstructorRef(constructorRef)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/constructors")
    public ResponseEntity<Constructor> create(@RequestBody Constructor constructor){
        if(constructor.getConstructorId() != null){
            return ResponseEntity.badRequest().build();
        }
        this.constructorService.saveConstructor(constructor);
        return ResponseEntity.ok(constructor);
    }

    @PutMapping("/constructors")
    public ResponseEntity<Constructor> update(@RequestBody Constructor constructor){
        this.constructorService.saveConstructor(constructor);
        return ResponseEntity.ok(constructor);
    }

    @Transactional
    @DeleteMapping("/constructors/{constructorRef}")
    public ResponseEntity<Constructor> deleteByConstructorRef(@PathVariable String constructorRef){
        this.constructorService.deleteConstructorByConstructorRef(constructorRef);
        return ResponseEntity.noContent().build();
    }
}
