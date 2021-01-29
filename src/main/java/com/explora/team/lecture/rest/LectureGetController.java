package com.explora.team.lecture.rest;

import com.explora.team.lecture.domain.Lecture;
import com.explora.team.lecture.domain.LectureRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lecture")
@CrossOrigin
public class LectureGetController {

    LectureRepository repository;

    LectureGetController(LectureRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Lecture>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<Lecture>> findTitle(@PathVariable String title){
        return ResponseEntity.ok(repository.findTitle(title));
    }

}
