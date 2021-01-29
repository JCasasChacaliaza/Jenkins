package com.explora.team.lecture.aplication;

import com.explora.team.lecture.domain.Lecture;
import com.explora.team.lecture.domain.LectureRepository;
import org.springframework.stereotype.Service;

@Service
public class LectureCreator {

    LectureRepository repository;

    LectureCreator(LectureRepository repository) {
        this.repository = repository;
    }

    public void create(Lecture lecture){
        repository.save(lecture);
    }

}
