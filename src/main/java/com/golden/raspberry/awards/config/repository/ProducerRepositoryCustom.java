package com.golden.raspberry.awards.config.repository;

import com.golden.raspberry.awards.config.entity.dto.ProducerDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerRepositoryCustom {

   List<ProducerDTO> findToJobOK();

}