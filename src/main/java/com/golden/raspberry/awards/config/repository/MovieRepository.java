package com.golden.raspberry.awards.config.repository;

import com.golden.raspberry.awards.config.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findAll();
}
