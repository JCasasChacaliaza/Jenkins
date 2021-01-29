package com.explora.team.lecture.aplication;

import com.explora.team.lecture.domain.Lecture;
import com.explora.team.lecture.domain.LectureRepository;
import org.springframework.stereotype.Service;

@Service
public class LectureUpdater {

    LectureRepository repository;

    LectureUpdater(LectureRepository repository) {
        this.repository = repository;
    }

    public void update(Lecture lecture) {
        repository.update(lecture);
    }

}
