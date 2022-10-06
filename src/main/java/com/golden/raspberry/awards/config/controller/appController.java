package com.golden.raspberry.awards.config.controller;

import com.golden.raspberry.awards.config.service.MovieService;
import com.golden.raspberry.awards.config.entity.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api")
public class appController {

    @Autowired
    MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, value = "/filter", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> filterMovies() {
        try {
            return new ResponseEntity<Object>(movieService.filter(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>("Error!", HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<Object>(movieService.getMovieById(id),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>("Error!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable("id") Integer id) {
        try {
            movieService.deleteMovie(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error!",HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createMovie(@Valid @RequestBody Movie movie) {
        return new ResponseEntity<Object>(movieService.create(movie), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Object> updateMovie(@Valid @PathVariable("id") Integer id, @RequestBody Movie movie) {
        try {
            Movie movieReturn = movieService.update(id, movie);
            if(movieReturn != null){
                return new ResponseEntity<Object>(movieReturn, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>("Error!",HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error!",HttpStatus.BAD_REQUEST);
        }
    }

}
