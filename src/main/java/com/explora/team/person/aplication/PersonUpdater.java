package com.explora.team.person.aplication;

import com.explora.team.person.domain.Person;
import com.explora.team.person.domain.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonUpdater {

    PersonRepository repository;

    PersonUpdater(PersonRepository repository) {
        this.repository = repository;
    }

    public void update(Person person){
        repository.update(person);
    }
}
