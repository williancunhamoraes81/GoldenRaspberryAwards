package com.golden.raspberry.awards.config.repository;

import com.golden.raspberry.awards.config.entity.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Integer>, ProducerRepositoryCustom{
    List<Producer> findAll();
}
