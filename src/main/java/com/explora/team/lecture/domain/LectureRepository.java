package com.explora.team.lecture.domain;

import java.util.List;

public interface LectureRepository {

    List<Lecture> findAll();
    List<Lecture> findTitle(String title);
    void save(Lecture lecture);
    void update(Lecture lecture);
    void delete(String idLecture);

}
