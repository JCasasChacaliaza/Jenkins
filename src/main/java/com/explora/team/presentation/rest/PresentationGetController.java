package com.explora.team.presentation.rest;

import com.explora.team.presentation.domain.Presentation;
import com.explora.team.presentation.domain.PresentationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/presentation")
@CrossOrigin
public class PresentationGetController {

    PresentationRepository repository;

    PresentationGetController(PresentationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Presentation>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

}
