package com.explora.team.presentation.rest;

import com.explora.team.presentation.aplication.PresentationUpdater;
import com.explora.team.presentation.domain.Presentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/presentation")
@CrossOrigin
public class PresentationPutController {

    PresentationUpdater presentationUpdater;

    PresentationPutController(PresentationUpdater presentationUpdater) {
        this.presentationUpdater = presentationUpdater;
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Presentation presentation){
        presentationUpdater.update(presentation);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
