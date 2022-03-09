package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dtos.MovieDto;
import com.devsuperior.dsmovie.dtos.ScoreDto;
import com.devsuperior.dsmovie.services.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDto saveScore(@RequestBody ScoreDto dto) {
        MovieDto movieDto = scoreService.saveScore(dto);
        return movieDto;
    }
    
}
