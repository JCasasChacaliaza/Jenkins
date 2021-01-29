package com.explora.team.speaker.aplication;

import com.explora.team.speaker.domain.Speaker;
import com.explora.team.speaker.domain.SpeakerRepository;
import org.springframework.stereotype.Service;

@Service
public class SpeakerCreator {

    SpeakerRepository repository;

    SpeakerCreator(SpeakerRepository repository) {
        this.repository = repository;
    }

    public void create(Speaker speaker){
        repository.save(speaker);
    }

}
