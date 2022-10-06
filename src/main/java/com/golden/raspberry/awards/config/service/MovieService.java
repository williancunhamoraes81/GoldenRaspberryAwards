package com.golden.raspberry.awards.config.service;

import com.golden.raspberry.awards.config.entity.Movie;
import com.golden.raspberry.awards.config.entity.dto.ResultDTO;
import com.golden.raspberry.awards.config.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;

    @Autowired
    ProducerService producerService;

    public void saveAll(final List<Movie> movies) {
        repository.saveAll(movies);
    }

    public void save(final Movie movie) {
        repository.save(movie);
    }

    public ResultDTO filter() {
        return producerService.filterProducer();
    }

    public Movie getMovieById(Integer id) {
        Optional<Movie> movieOpt = repository.findById(id);
        if(Objects.nonNull(movieOpt)){
            return movieOpt.get();
        }else{
            return null;
        }
    }


    public void deleteMovie(Integer id) {
        repository.delete(Movie.builder().id(id).build());
    }

    public Movie create(Movie movie) {
        return repository.save(movie);
    }

    public Movie update(Integer id, Movie movie) {
        Optional<Movie> movieOpt = repository.findById(id);
        if(Objects.nonNull(movieOpt)){

            movieOpt.get().setYear(movie.getYear());
            movieOpt.get().setTitle(movie.getTitle());
            movieOpt.get().setStudios(movie.getStudios());
            movieOpt.get().setProducers(movie.getProducers());
            movieOpt.get().setWinner(movie.getWinner());

            return repository.save(movieOpt.get());
        }else{
            return null;
        }
    }
}
