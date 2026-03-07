package com.movie.management.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.management.system.dao.MovieDAO;
import com.movie.management.system.model.MovieManagementSystem;

@Service
public class MovieService {
    
    private final MovieDAO movieDAO;
    
    @Autowired
    public MovieService(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }
    
    public Optional<MovieManagementSystem> getMovieById(Integer id) {
        return movieDAO.findById(id);
    }
    
    public List<MovieManagementSystem> getAllMovie() {
        return movieDAO.findAll();
    }
    
    public MovieManagementSystem createMovie(MovieManagementSystem movie) {
        return movieDAO.save(movie);
    }
    
    public MovieManagementSystem updateMovie(Integer id, MovieManagementSystem updatedMovie) {
        return movieDAO.findById(id).map(existing -> {
            existing.setTitle(updatedMovie.getTitle());
            existing.setDirector(updatedMovie.getDirector());
            existing.setGenre(updatedMovie.getGenre());
            existing.setReleaseYear(updatedMovie.getReleaseYear());
            existing.setRating(updatedMovie.getRating());
            return movieDAO.save(existing);
        }).orElse(null);
    }
    
    public void deleteMovie(Integer id) {
        movieDAO.deleteById(id);
    }
}