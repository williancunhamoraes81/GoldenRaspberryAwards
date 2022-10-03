package com.golden.raspberry.awards.config.repository;

import com.golden.raspberry.awards.config.entity.dto.ProducerDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Repository
public class ProducerRepositoryImpl implements ProducerRepositoryCustom, Serializable {

   @PersistenceContext
   EntityManager em;

   public List<ProducerDTO> findToJobOK(){
      String sql = "select new com.golden.raspberry.awards.config.entity.dto.ProducerDTO(p.name as name, m.year as year) " +
              "FROM Producer AS p " +
              "INNER JOIN Movie AS m ON p.movie.id = m.id " +
              "WHERE m.winner = 'yes'" +
              "GROUP BY p.name, m.year ";
      Query query = em.createQuery(sql);
      return query.getResultList();

   }

}