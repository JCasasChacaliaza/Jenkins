package com.explora.team.person.persistence;

import com.explora.team.person.domain.Person;
import com.explora.team.person.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonImpl implements PersonRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> findAll() {
        final String SQL_GET_ALL = "select * from Person";
        return jdbcTemplate.query(SQL_GET_ALL, new PersonMapper());
    }

    @Override
    public void save(Person person) {
        final String SQL_INSERT = "insert into Person(" +
                "idPerson, " +
                "namePerson, " +
                "lastname, " +
                "mail," +
                "typePerson) values(?, ?, ?, ?, ?)";

        jdbcTemplate.update(SQL_INSERT,
                person.getIdPerson(),
                person.getNamePerson(),
                person.getLastname(),
                person.getMail(),
                person.getTypePerson());
    }

    @Override
    public void delete(int idPerson) {
        final String SQL_DELETE = "delete from Person where idPerson = ?";
        jdbcTemplate.update(SQL_DELETE, idPerson);
    }

    @Override
    public void update(Person person) {
        final String SQL_UPDATE = "update Person set " +
                "namePerson = ?, " +
                "lastname = ?, " +
                "mail = ?," +
                "typePerson = ?  where idPerson = ?";

        jdbcTemplate.update(SQL_UPDATE,
                person.getNamePerson(),
                person.getLastname(),
                person.getMail(),
                person.getTypePerson(),
                person.getIdPerson());
    }
}
