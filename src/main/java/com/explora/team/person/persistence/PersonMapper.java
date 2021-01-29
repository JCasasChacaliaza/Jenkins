package com.explora.team.person.persistence;

import com.explora.team.person.domain.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(
                rs.getString("idPerson"),
                rs.getString("namePerson"),
                rs.getString("lastname"),
                rs.getString("mail"),
                rs.getInt("typePerson"),
                rs.getString("userName"),
                rs.getString("userPassword")
        );
    }

}
