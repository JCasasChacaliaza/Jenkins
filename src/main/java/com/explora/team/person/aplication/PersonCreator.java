package com.explora.team.person.aplication;

import com.explora.team.person.domain.Person;
import com.explora.team.person.domain.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonCreator {

    PersonRepository repository;

    PersonCreator(PersonRepository repository) {
        this.repository = repository;
    }

    public void create(Person person){
        repository.save(person);
    }

}
