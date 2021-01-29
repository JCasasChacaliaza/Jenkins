package com.explora.team.speaker.persistence;

import com.explora.team.speaker.domain.Person;
import com.explora.team.speaker.domain.Speaker;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpeakerMapper implements RowMapper<Speaker> {

    @Override
    public Speaker mapRow(ResultSet rs, int rowsNum) throws SQLException {
        return new Speaker(
                rs.getString("idSpeaker"),
                new Person(
                        rs.getString("idPerson"),
                        rs.getString("namePerson"),
                        rs.getString("lastname"),
                        rs.getString("mail"),
                        rs.getInt("typePerson")
                ),
                rs.getString("profession"),
                rs.getString("cellPhone"),
                rs.getString("descriptionSpeaker"),
                rs.getString("companyName"),
                rs.getString("nationality")
        );
    }

}
