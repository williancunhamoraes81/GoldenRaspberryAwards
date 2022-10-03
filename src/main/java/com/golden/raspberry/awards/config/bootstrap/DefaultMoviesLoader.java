package com.golden.raspberry.awards.config.bootstrap;

import com.golden.raspberry.awards.config.entity.Producer;
import com.golden.raspberry.awards.config.entity.Studio;
import com.golden.raspberry.awards.config.service.MovieService;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.golden.raspberry.awards.config.entity.Movie;
import com.golden.raspberry.awards.config.service.ProducerService;
import com.golden.raspberry.awards.config.service.StudioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class DefaultMoviesLoader implements CommandLineRunner {

    @Autowired
    MovieService movieService;

    @Autowired
    ProducerService producerService;

    @Autowired
    StudioService studioService;

    @Override
    public void run(String... args) throws Exception {
        load();
    }

    private void load() throws IOException, CsvException {

       // List<Movie> listMovies = new ArrayList<>();

        File file = new File("src/main/resources/csv/movieList.csv");
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(new FileReader(file.getAbsoluteFile())).withCSVParser(parser).build();
        csvReader.skip(1);

        List<String[]> movieCsv = csvReader.readAll();
        if(movieCsv.size() > 0 ){
            movieCsv.stream().forEach(data -> {
                Movie movie = Movie.builder()
                        .year(data[0].toString())
                        .title(data[1].toString())
                        .winner(data[4].toString())
                        .build();
                movieService.create(movie);

                movie.setProducers(buildProducers(data[3], movie));
                movie.setStudios(buildStudios(data[2], movie));
                movieService.save(movie);
            });

        }
    }

    private List<Studio> buildStudios(String data, Movie movie){
        List<String> studios = new ArrayList<String>(Arrays.asList(data.split(",| and ")));
        List<Studio> listStudios = new ArrayList<>();
        studios.stream().forEach(m -> {
            if(!m.equals("")){
                Studio studio = Studio.builder().name(m.trim()).movie(movie).build();
                studioService.create(studio);
                listStudios.add(studio);
            }
        });
        return listStudios;
    }

    private List<Producer> buildProducers(String data, Movie movie){
        List<String> producers = new ArrayList<String>(Arrays.asList(data.split((",| and "))));
        List<Producer> listProducers = new ArrayList<>();
        producers.stream().forEach(m -> {
            if(!m.equals("")){
                Producer producer = Producer.builder().name(m.trim()).movie(movie).build();
                producerService.create(producer);
                listProducers.add(producer);
            }
        });
        return listProducers;
    }
}
