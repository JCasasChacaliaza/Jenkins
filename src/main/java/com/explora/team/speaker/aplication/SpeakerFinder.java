package com.explora.team.speaker.aplication;

import com.explora.team.speaker.domain.Speaker;
import com.explora.team.speaker.domain.SpeakerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerFinder {

    SpeakerRepository repository;

    SpeakerFinder(SpeakerRepository repository) {
        this.repository = repository;
    }

    List<Speaker> findAll() {
        return repository.findAll();
    }

    List<Speaker> findName(String name) {
        return repository.findName(name);
    }

}
