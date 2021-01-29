package com.explora.team.presentation.domain;

import java.util.List;

public interface PresentationRepository {

    List<Presentation> findAll();
    void save(Presentation presentation);
    void update(Presentation presentation);
    void delete(String idPresentation);

}
