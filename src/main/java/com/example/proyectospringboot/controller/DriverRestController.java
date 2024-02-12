package com.example.proyectospringboot.controller;

import com.example.proyectospringboot.dto.DriverListDetailsDTO;
import com.example.proyectospringboot.entity.Driver;
import com.example.proyectospringboot.projection.DriverDetailsDTO;
import com.example.proyectospringboot.service.DriverServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverRestController {
    private final DriverServiceImpl driverService;
    @Autowired
    public DriverRestController(DriverServiceImpl driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok().body(driverService.getAllDrivers());
    }

//    @GetMapping("drivers")
//    public ResponseEntity<List<DriverDetails>> getAllPagedAndSorted(@RequestParam(defaultValue = "0") int page,
//                                                                    @RequestParam(defaultValue = "10") int size,
//                                                                    @RequestParam(defaultValue = "code") String sortBy,
//                                                                    @RequestParam(defaultValue = "ASC") String sortDirection){
//        Page<DriverDetails> driverDTOPage = this.driverService.getAllDriversPaged(page,size, sortBy, sortDirection);
//        return ResponseEntity.ok(driverDTOPage.)
//    }



    @GetMapping("/drivers/{code}")
    public ResponseEntity<DriverDetailsDTO> getByCode(@PathVariable String code){
        return this.driverService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver){
        if (driver.getDriverId() != null){
            return ResponseEntity.badRequest().build();
        }
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver){
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    @Transactional
    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> deleteByCode(@PathVariable String code){
        this.driverService.deleteDriverByCode(code);
        return ResponseEntity.noContent().build();
    }
}
