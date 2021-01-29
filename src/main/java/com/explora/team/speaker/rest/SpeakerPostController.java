package com.explora.team.speaker.rest;

import com.explora.team.speaker.aplication.SpeakerCreator;
import com.explora.team.speaker.domain.Speaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/speaker")
@CrossOrigin
public class SpeakerPostController {

    SpeakerCreator speakerCreator;

    SpeakerPostController(SpeakerCreator speakerCreator) {
        this.speakerCreator = speakerCreator;
    }

    @PostMapping
    public ResponseEntity saveSpeaker(@RequestBody Speaker speaker) {
        speakerCreator.create(speaker);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
