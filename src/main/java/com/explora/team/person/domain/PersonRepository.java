package com.explora.team.person.domain;

import java.util.List;

public interface PersonRepository {

    List<Person> findAll();
    void save(Person person);
    void delete(int idPerson);
    void update(Person person);

}
