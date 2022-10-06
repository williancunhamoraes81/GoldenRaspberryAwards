package com.golden.raspberry.awards.config.service;

import com.golden.raspberry.awards.config.entity.Producer;
import com.golden.raspberry.awards.config.entity.dto.ResultDTO;
import com.golden.raspberry.awards.config.entity.dto.ResultTypeDTO;
import com.golden.raspberry.awards.config.repository.ProducerRepository;
import com.golden.raspberry.awards.config.entity.dto.ProducerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProducerService {

    @Autowired
    ProducerRepository repository;

    public void saveAll(final List<Producer> producers) {
        repository.saveAll(producers);
    }

    private List<Integer> newListYear(Integer year){
        List<Integer> list = new ArrayList<>();
        list.add(year);
        return list;
    }

    private List<Integer> addListYear(Integer year, List<Integer> listYear){
        listYear.add(year);
        return listYear;
    }

    public ResultDTO filterProducer() {
        List<ProducerDTO> listProducers = repository.findToJobOK();
        Map<String, List<Integer>> mapProducer = new HashMap<>();

        // Gera lista
        listProducers
            .stream()
             .forEach(m -> {
                Integer year = Integer.parseInt(m.getYear());
                if(!mapProducer.containsKey(m.getName())){
                   mapProducer.put(m.getName(), newListYear(year));
                }else{
                   mapProducer.put(m.getName(), addListYear(year,mapProducer.get(m.getName())));
                }
             });

        // Remove quem ganhou apenas uma vez
        mapProducer.entrySet().removeIf(e -> e.getValue().size() < 2);
        return buildReturn(mapProducer);
    }

    private ResultDTO buildReturn(Map<String, List<Integer>> mapProducer){

        List<ResultTypeDTO> resultTypeDTO = buildListRasultTypeDTO(mapProducer);

        int max = resultTypeDTO.stream()
                .mapToInt(ResultTypeDTO::getInterval)
                .max()
                .orElse(-1);

        int min = resultTypeDTO.stream()
                .mapToInt(ResultTypeDTO::getInterval)
                .min()
                .orElse(-1);

        //Monta retorno
        return ResultDTO
                .builder()
                .max(resultTypeDTO.stream()
                        .filter(s -> s.getInterval() == max)
                        .collect(Collectors.toList()))
                .min(resultTypeDTO.stream()
                        .filter(s -> s.getInterval() == min)
                        .collect(Collectors.toList()))
                .build();
    }

    private  List<ResultTypeDTO> buildListRasultTypeDTO(Map<String, List<Integer>> mapProducer){
        List<ResultTypeDTO> resultTypeDTO = new ArrayList<>();
        Integer i = 0;

        // Organiza retorno
        mapProducer.entrySet().stream().forEach(m -> {
            if(m.getValue().size() > 2) {

                for (int n=0; n < (m.getValue().size() - 1); n++){
                    Integer interval = (m.getValue().get(n+1) - m.getValue().get(n));
                    resultTypeDTO.add(ResultTypeDTO
                            .builder()
                            .producer(m.getKey())
                            .previousWin(m.getValue().get(n).toString())
                            .followingWin(m.getValue().get(n+1).toString())
                            .interval(interval)
                            .build());

                }
                return;
            }else{
                Integer min = Collections.min(m.getValue());
                Integer max = Collections.max(m.getValue());
                Integer interval = (max - min);

                resultTypeDTO.add(ResultTypeDTO
                        .builder()
                        .producer(m.getKey())
                        .previousWin(min.toString())
                        .followingWin(max.toString())
                        .interval(interval)
                        .build());

            }

        });

        return resultTypeDTO;

    }


    public Producer getProducerById(Integer id) {
        Optional<Producer> producerOpt = repository.findById(id);
        if(Objects.nonNull(producerOpt)){
            return producerOpt.get();
        }else{
            return null;
        }
    }

    public Producer create(Producer producer) {
        return repository.save(producer);
    }

}
