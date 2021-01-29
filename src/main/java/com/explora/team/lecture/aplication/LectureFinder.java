package com.explora.team.lecture.aplication;

import com.explora.team.lecture.domain.Lecture;
import com.explora.team.lecture.domain.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureFinder {

    LectureRepository repository;

    LectureFinder(LectureRepository repository) {
        this.repository = repository;
    }

    List<Lecture> findAll() {
        return repository.findAll();
    }

    List<Lecture> findTitle(String title) {
        return repository.findTitle(title);
    }

}
