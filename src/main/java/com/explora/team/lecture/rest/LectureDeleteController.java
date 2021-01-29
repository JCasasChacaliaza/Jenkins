package com.explora.team.lecture.rest;

import com.explora.team.lecture.aplication.LectureDeleter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lecture")
@CrossOrigin
public class LectureDeleteController {

    LectureDeleter lectureDeleter;

    LectureDeleteController(LectureDeleter lectureDeleter) {
        this.lectureDeleter = lectureDeleter;
    }

    @DeleteMapping("/{idLecture}")
    public ResponseEntity delete(@PathVariable String idLecture){
        lectureDeleter.delete(idLecture);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
