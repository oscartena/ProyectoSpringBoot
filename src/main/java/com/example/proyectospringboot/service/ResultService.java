package com.example.proyectospringboot.service;

import com.example.proyectospringboot.entity.Result;
import com.example.proyectospringboot.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultsRepository resultRepository;

    @Autowired
    public ResultService(ResultsRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> findAll() {
        return resultRepository.findAll();
    }



}
