package com.explora.team.speaker.rest;

import com.explora.team.speaker.aplication.SpeakerDeleter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/speaker")
@CrossOrigin
public class SpeakerDeleteController {

    SpeakerDeleter speakerDeleter;

    SpeakerDeleteController(SpeakerDeleter speakerDeleter) {
        this.speakerDeleter = speakerDeleter;
    }

    @DeleteMapping("/{idSpeaker}")
    public ResponseEntity delete(@PathVariable int idSpeaker){
        speakerDeleter.delete(idSpeaker);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
