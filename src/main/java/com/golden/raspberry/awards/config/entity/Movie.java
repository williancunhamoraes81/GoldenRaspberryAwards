package com.golden.raspberry.awards.config.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "movie")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Component
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Campo year não pode ser nulo.")
    private String year;

    @NotNull(message = "Campo title não pode ser nulo.")
    private String title;

    @OneToMany
    private List<Studio> studios;

    @OneToMany
    private List<Producer> producers;

    @NotNull(message = "Campo winner não pode ser nulo.")
    private String winner;

}
