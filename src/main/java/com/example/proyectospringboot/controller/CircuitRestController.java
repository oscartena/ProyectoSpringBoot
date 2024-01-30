package com.example.proyectospringboot.controller;

import com.example.proyectospringboot.entity.Circuit;
import com.example.proyectospringboot.service.CircuitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CircuitRestController {
    private final CircuitService circuitService;

    public CircuitRestController(CircuitService circuitService) {
        this.circuitService = circuitService;
    }

    @GetMapping("/circuits")
    public ResponseEntity<List<Circuit>> getAllCircuits() {
        return ResponseEntity.ok().body(circuitService.getAllCircuits());
    }

    @GetMapping("/circuits/{circuitRef}")
    public ResponseEntity<Circuit> getByCircuitRef(@PathVariable String circuitRef) {
        return this.circuitService.getCircuitByCircuitRef(circuitRef)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/circuits")
    public ResponseEntity<Circuit> create(@RequestBody Circuit circuit) {
        if (circuit.getCircuitId() != null) {
            return ResponseEntity.badRequest().build();
        }
        this.circuitService.saveCircuit(circuit);
        return ResponseEntity.ok(circuit);
    }

    @PutMapping("/circuits")
    public ResponseEntity<Circuit> update(@RequestBody Circuit circuit) {
        this.circuitService.saveCircuit(circuit);
        return ResponseEntity.ok(circuit);
    }

    @DeleteMapping("/circuits/{circuitRef}")
    public ResponseEntity<Circuit> deleteByCircuitRef(@PathVariable String circuitRef) {
        this.circuitService.deleteCircuitByCircuitRef(circuitRef);
        return ResponseEntity.noContent().build();
    }
}
