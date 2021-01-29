package com.explora.team.person.rest;

import com.explora.team.person.domain.Person;
import com.explora.team.person.domain.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
public class PersonGetController {

    PersonRepository repository;

    PersonGetController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

}
