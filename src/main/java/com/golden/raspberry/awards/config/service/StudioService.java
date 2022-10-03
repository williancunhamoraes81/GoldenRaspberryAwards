package com.golden.raspberry.awards.config.service;

import com.golden.raspberry.awards.config.entity.Studio;
import com.golden.raspberry.awards.config.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {

    @Autowired
    StudioRepository repository;

    public void saveAll(final List<Studio> studios) {
        repository.saveAll(studios);
    }

    public Studio create(Studio studio) {
        return repository.save(studio);
    }

}
