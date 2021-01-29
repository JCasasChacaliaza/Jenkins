package com.explora.team.speaker.domain;

import java.util.List;

public interface SpeakerRepository {

    List<Speaker> findAll();
    List<Speaker> findName(String name);
    void save(Speaker speaker);
    void update(Speaker speaker);
    void delete(int idSpeaker);

}
