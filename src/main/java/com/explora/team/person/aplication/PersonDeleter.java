package com.explora.team.person.aplication;

import com.explora.team.person.domain.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonDeleter {

    PersonRepository repository;

    PersonDeleter(PersonRepository repository) {
        this.repository = repository;
    }

    public void delete(int idPerson){
        repository.delete(idPerson);
    }

}
