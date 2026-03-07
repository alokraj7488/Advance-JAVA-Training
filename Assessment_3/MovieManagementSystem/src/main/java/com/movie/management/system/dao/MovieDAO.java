package com.movie.management.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.management.system.model.MovieManagementSystem;

@Repository
public interface MovieDAO extends JpaRepository<MovieManagementSystem, Integer>{

}
