package com.explora.team.speaker.aplication;

import com.explora.team.speaker.domain.SpeakerRepository;
import org.springframework.stereotype.Service;

@Service
public class SpeakerDeleter {

    SpeakerRepository repository;

    SpeakerDeleter(SpeakerRepository repository) {
        this.repository = repository;
    }

    public void delete(int idSpeaker) {
        repository.delete(idSpeaker);
    }

}
