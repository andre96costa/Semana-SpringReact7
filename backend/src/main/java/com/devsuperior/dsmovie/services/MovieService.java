package com.devsuperior.dsmovie.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmovie.dtos.MovieDto;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDto> findAll(Pageable pageable) {
        Page<Movie> movies = movieRepository.findAll(pageable);
        Page<MovieDto> page = movies.map(m -> new MovieDto(m));
        return page;
    }

    @Transactional(readOnly = true)
    public MovieDto findById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            return new MovieDto();
        }
        return new MovieDto(movie.get());
    }
}
