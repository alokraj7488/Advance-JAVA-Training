package com.movie.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.management.system.model.MovieManagementSystem;
import com.movie.management.system.service.MovieService;

import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    
    private final MovieService movieService;
    
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    
    @GetMapping
    public String viewMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovie());
        return "movies";
    }
    
    @GetMapping("/{id}")
    public String viewMovieById(@PathVariable Integer id, Model model) {
        Optional<MovieManagementSystem> movieOpt = movieService.getMovieById(id);
        if (!movieOpt.isPresent()) {
            return "redirect:/movies?error=not_found";
        }
        model.addAttribute("movie", movieOpt.get());
        return "movie";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new MovieManagementSystem());
        return "addMovie";
    }
    
    @PostMapping("/save")
    public String saveMovie(@ModelAttribute MovieManagementSystem movie) {
        movieService.createMovie(movie);
        return "redirect:/movies";
    }
    
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Optional<MovieManagementSystem> movieOpt = movieService.getMovieById(id);
        if (!movieOpt.isPresent()) {
            return "redirect:/movies?error=not_found";
        }
        model.addAttribute("movie", movieOpt.get());
        return "updateMovie";
    }
    
    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable Integer id, @ModelAttribute MovieManagementSystem movie) {
        movieService.updateMovie(id, movie);
        return "redirect:/movies";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}