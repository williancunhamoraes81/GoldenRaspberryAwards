package com.golden.raspberry.awards.config.repository;

import com.golden.raspberry.awards.config.entity.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioRepository extends CrudRepository<Studio, Integer> {
    List<Studio> findAll();
}
