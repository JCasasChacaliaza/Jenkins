package com.explora.team.person.aplication;

import com.explora.team.person.domain.Person;
import com.explora.team.person.domain.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonFinder {

    PersonRepository repository;

    PersonFinder(PersonRepository repository) {
        this.repository = repository;
    }

    List<Person> findAll(){
        return repository.findAll();
    }

}
