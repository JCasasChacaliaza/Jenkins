package com.explora.team.presentation.aplication;

import com.explora.team.presentation.domain.Presentation;
import com.explora.team.presentation.domain.PresentationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationFinder {

    PresentationRepository repository;

    PresentationFinder(PresentationRepository repository) {
        this.repository = repository;
    }

    List<Presentation> findAll() {
        return repository.findAll();
    }

}
