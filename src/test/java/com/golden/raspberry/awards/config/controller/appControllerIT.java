package com.golden.raspberry.awards.config.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.golden.raspberry.awards.config.AwardsSpringbootApplicationIT;
import com.golden.raspberry.awards.config.entity.Movie;
import com.golden.raspberry.awards.config.entity.Producer;
import com.golden.raspberry.awards.config.entity.Studio;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;

class appControllerIT extends AwardsSpringbootApplicationIT{

    private static final String URL = "/api";
    private static final String ID_MOCK = RandomStringUtils.randomNumeric(1);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Testa retorno Movie por id com sucesso")
    @Test
    void testValidResponse() throws Exception {

        Movie validResponse = createMovie();

        when(movieService.getMovieById(eq(Integer.parseInt(ID_MOCK)))).thenReturn(validResponse);

        mockMvc
                .perform(
                        MockMvcRequestBuilders.get(URL + "/" + ID_MOCK)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(validResponse.getTitle()))
                .andExpect(jsonPath("$.year").value(validResponse.getYear()))
                .andExpect(jsonPath("$.winner").value(validResponse.getWinner()))
                .andExpect(jsonPath("$.producers").isArray())
                .andExpect(jsonPath("$.studios").isArray());
    }

    @DisplayName("Test deve retornar 201 e criação com sucesso")
    @Test
    void testCreateMovieSucesso() throws Exception {

        Movie request = createMovie();
        String requestBody = objectMapper.writeValueAsString(request);

        Movie validResponse = createMovie();
        when(movieService.create(
                ArgumentMatchers.any(Movie.class))).thenReturn(validResponse);

        mockMvc
                .perform(
                        MockMvcRequestBuilders.post(URL)
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value(validResponse.getTitle()))
                .andExpect(jsonPath("$.year").value(validResponse.getYear()))
                .andExpect(jsonPath("$.winner").value(validResponse.getWinner()))
                .andExpect(jsonPath("$.producers").isArray())
                .andExpect(jsonPath("$.studios").isArray());

    }


    @DisplayName("Quando for feita uma request de DELETE com o parâmetro válido, deve retornar sucesso")
    @Test
    void whenValidDeleteRequestShouldReturnSuccess() throws Exception {

        Integer movieId = Integer.parseInt(ID_MOCK);

        mockMvc
                .perform(MockMvcRequestBuilders.delete(URL + "/" + ID_MOCK)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(movieService).deleteMovie(movieId);
    }


    public static List<Studio> createResponseStudios() {
        List<Studio> response = new ArrayList<>();
        Studio studio = Studio.builder()
                .name("Teste")
                .build();
        response.add(studio);
        return response;
    }

    public static List<Producer> createResponseProducers() {
        List<Producer> response = new ArrayList<>();
        Producer producer = Producer.builder()
                .name("Teste")
                .build();
        response.add(producer);
        return response;
    }


    public static Movie createMovie() {
        return Movie.builder()
                .id(Integer.parseInt(ID_MOCK))
                .producers(createResponseProducers())
                .studios(createResponseStudios())
                .title("Teste1")
                .year("2019")
                .winner("yes")
                .build();
    }

    public static Movie createMovieWithOutId() {
        return Movie.builder()
                .producers(createResponseProducers())
                .studios(createResponseStudios())
                .title("Teste1")
                .year("2019")
                .winner("yes")
                .build();
    }

}
