package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dtos.MovieDto;
import com.devsuperior.dsmovie.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    
    @GetMapping
    public Page<MovieDto> findAll(Pageable pageable) {
        return movieService.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public MovieDto findById(@PathVariable("id") Long id) {
        return movieService.findById(id);
    }
}
