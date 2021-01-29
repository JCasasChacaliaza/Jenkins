package com.explora.team.lecture.aplication;

import com.explora.team.lecture.domain.LectureRepository;
import org.springframework.stereotype.Service;

@Service
public class LectureDeleter {

    LectureRepository repository;

    LectureDeleter(LectureRepository repository) {
        this.repository = repository;
    }

    public void delete(String idLecture){
        repository.delete(idLecture);
    }
}
