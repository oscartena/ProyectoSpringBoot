package com.example.proyectospringboot.controller;

import com.example.proyectospringboot.entity.Result;
import com.example.proyectospringboot.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultRestController {

    private final ResultService resultService;

    @Autowired
    public ResultRestController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/results")
    public ResponseEntity<List<Result>> getAllResults() {
        List<Result> results = resultService.findAll();
        return ResponseEntity.ok(results);
    }


}
