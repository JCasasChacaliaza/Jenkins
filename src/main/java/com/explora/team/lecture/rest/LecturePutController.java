package com.explora.team.lecture.rest;

import com.explora.team.lecture.aplication.LectureUpdater;
import com.explora.team.lecture.domain.Lecture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lecture")
@CrossOrigin
public class LecturePutController {

    LectureUpdater lectureUpdater;

    LecturePutController(LectureUpdater lectureUpdater) {
        this.lectureUpdater = lectureUpdater;
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Lecture lecture) {
        lectureUpdater.update(lecture);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
