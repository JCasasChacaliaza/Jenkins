package com.explora.team.presentation.aplication;

import com.explora.team.presentation.domain.PresentationRepository;
import org.springframework.stereotype.Service;

@Service
public class PresentationDeleter {

    PresentationRepository repository;

    PresentationDeleter(PresentationRepository repository) {
        this.repository = repository;
    }

    public void delete(String idPresentation) {
        repository.delete(idPresentation);
    }
}
