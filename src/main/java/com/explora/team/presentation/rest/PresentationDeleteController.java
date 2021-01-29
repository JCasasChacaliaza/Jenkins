package com.explora.team.presentation.rest;

import com.explora.team.presentation.aplication.PresentationDeleter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/presentation")
@CrossOrigin
public class PresentationDeleteController {

    PresentationDeleter presentationDeleter;

    PresentationDeleteController(PresentationDeleter presentationDeleter) {
        this.presentationDeleter = presentationDeleter;
    }

    @DeleteMapping("/{idPresentation}")
    public ResponseEntity delete(@PathVariable String idPresentation) {
        presentationDeleter.delete(idPresentation);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
