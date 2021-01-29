package com.explora.team.person.rest;

import com.explora.team.person.aplication.PersonUpdater;
import com.explora.team.person.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
public class PersonPutController {

    PersonUpdater personUpdater;

    PersonPutController(PersonUpdater personUpdater) {
        this.personUpdater = personUpdater;
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Person person){
        personUpdater.update(person);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
