package com.explora.team.presentation.aplication;

import com.explora.team.lecture.domain.Lecture;
import com.explora.team.presentation.domain.Presentation;
import com.explora.team.presentation.domain.PresentationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentationCreator {

    PresentationRepository repository;

    PresentationCreator(PresentationRepository repository) {
        this.repository = repository;
    }

    public void create(List<Presentation> presentations){
        presentations.forEach(presentation -> {
            Presentation presentation1 = new Presentation(
                    presentation.getIdPresentation(),
                    new Lecture(
                      presentation.getLecture().getIdLecture(),
                      presentation.getLecture().getTitle(),
                      presentation.getLecture().getStartDate(),
                      presentation.getLecture().getEndDate()
                    ),
                    presentation.getDayPresentation(),
                    presentation.getTheme(),
                    presentation.getDescriptionPresentation(),
                    presentation.getTypePresentation(),
                    presentation.getVideoLink()
            );
            repository.save(presentation1);
        });
    }

}
