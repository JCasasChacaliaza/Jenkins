package com.explora.team.presentation.rest;

import com.explora.team.presentation.aplication.PresentationCreator;
import com.explora.team.presentation.domain.Presentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/presentation")
@CrossOrigin
public class PresentationPostController {

    PresentationCreator presentationCreator;

    PresentationPostController(PresentationCreator presentationCreator) {
        this.presentationCreator = presentationCreator;
    }

    @PostMapping
    public ResponseEntity savePresentation(@RequestBody List<Presentation> presentation) {
        presentationCreator.create(presentation);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
