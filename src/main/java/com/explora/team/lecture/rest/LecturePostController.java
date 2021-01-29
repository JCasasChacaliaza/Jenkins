package com.explora.team.lecture.rest;

import com.explora.team.lecture.aplication.LectureCreator;
import com.explora.team.lecture.domain.Lecture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lecture")
@CrossOrigin
public class LecturePostController {

    LectureCreator lectureCreator;

    LecturePostController(LectureCreator lectureCreator) {
        this.lectureCreator = lectureCreator;
    }

    @PostMapping
    public ResponseEntity saveLecture(@RequestBody Lecture lecture) {
        lectureCreator.create(lecture);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
