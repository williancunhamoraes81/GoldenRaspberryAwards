package com.golden.raspberry.awards.config.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "producer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Component
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Campo name não pode ser nulo.")
    private String name;

    @ManyToOne
    private Movie movie;

}
