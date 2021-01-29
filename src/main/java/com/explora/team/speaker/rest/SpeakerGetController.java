package com.explora.team.speaker.rest;

import com.explora.team.speaker.domain.Speaker;
import com.explora.team.speaker.domain.SpeakerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/speaker")
@CrossOrigin
public class SpeakerGetController {

    SpeakerRepository repository;

    SpeakerGetController(SpeakerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Speaker>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/searchName/{name}")
    ResponseEntity<List<Speaker>> findName(@PathVariable("name") String name) {
        return ResponseEntity.ok(repository.findName(name));
    }

}
