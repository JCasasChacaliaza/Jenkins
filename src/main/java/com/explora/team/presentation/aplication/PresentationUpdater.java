package com.explora.team.presentation.aplication;

import com.explora.team.presentation.domain.Presentation;
import com.explora.team.presentation.domain.PresentationRepository;
import org.springframework.stereotype.Service;

@Service
public class PresentationUpdater {

    PresentationRepository repository;

    PresentationUpdater(PresentationRepository repository) {
        this.repository = repository;
    }

    public void update(Presentation presentation) {
        repository.update(presentation);
    }

}
