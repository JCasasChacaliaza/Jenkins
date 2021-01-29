package com.explora.team.speaker.rest;

import com.explora.team.speaker.aplication.SpeakerUpdater;
import com.explora.team.speaker.domain.Speaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/speaker")
@CrossOrigin
public class SpeakerPutController {

    SpeakerUpdater speakerUpdater;

    SpeakerPutController(SpeakerUpdater speakerUpdater) {
        this.speakerUpdater = speakerUpdater;
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Speaker speaker) {
        speakerUpdater.update(speaker);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
