package com.explora.team.person.rest;

import com.explora.team.person.aplication.PersonCreator;
import com.explora.team.person.domain.Person;
import com.explora.team.person.domain.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
public class PersonPostController {

    PersonCreator personCreator;

    PersonPostController(PersonCreator personCreator) {
        this.personCreator = personCreator;
    }

    @PostMapping
    public ResponseEntity savePerson(@RequestBody Person person){
        personCreator.create(person);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
