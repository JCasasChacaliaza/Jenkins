package com.explora.team.speaker.persistence;

import com.explora.team.person.persistence.PersonMapper;
import com.explora.team.speaker.domain.Speaker;
import com.explora.team.speaker.domain.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpeakerImpl implements SpeakerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Speaker> findAll() {
        final String SQL_GET_ALL = "select \n" +
                "    pn.idperson, pn.nameperson, pn.lastname," +
                "    pn.mail, pn.typePerson,\n" +
                "    sp.idSpeaker, sp.idPerson, sp.profession,\n" +
                "    sp.cellPhone, sp.descriptionSpeaker,\n" +
                "    sp.companyName, sp.nationality\n" +
                "from speaker sp\n" +
                "    inner join person pn\n" +
                "        on pn.idperson = sp.idperson ";
        return jdbcTemplate.query(SQL_GET_ALL, new SpeakerMapper());
    }

    @Override
    public List<Speaker> findName(String name) {
        final String SQL_GET_ALL = "select \n" +
        "    pn.idperson, pn.nameperson, pn.lastname," +
        "    pn.mail, pn.typePerson,\n" +
        "    sp.idSpeaker, sp.idPerson, sp.profession,\n" +
        "    sp.cellPhone, sp.descriptionSpeaker,\n" +
        "    sp.companyName, sp.nationality\n" +
        "from speaker sp\n" +
        "    inner join person pn\n" +
        "        on pn.idperson = sp.idperson " +
        "where" +
        "    pn.nameperson like ?";
        return jdbcTemplate.query(SQL_GET_ALL, new SpeakerMapper(), "%" + name + "%");  
    }

    @Override
    public void save(Speaker speaker) {
        final String SQL_INSERT_PERSON = "insert into Person(" +
                "idPerson, " +
                "namePerson, " +
                "lastname, " +
                "mail," +
                "typePerson) values(?, ?, ?, ?, ?)";

        jdbcTemplate.update(SQL_INSERT_PERSON,
                speaker.getPerson().getIdPerson(),
                speaker.getPerson().getNamePerson(),
                speaker.getPerson().getLastname(),
                speaker.getPerson().getMail(),
                speaker.getPerson().getTypePerson());

        final String SQL_INSERT_SPEAKER = "insert into Speaker (" +
                "idSpeaker," +
                "idPerson," +
                "profession," +
                "cellPhone," +
                "descriptionSpeaker," +
                "companyName," +
                "nationality) values (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(SQL_INSERT_SPEAKER,
                speaker.getIdSpeaker(),
                speaker.getPerson().getIdPerson(),
                speaker.getProfession(),
                speaker.getCellPhone(),
                speaker.getDescriptionSpeaker(),
                speaker.getCompanyName(),
                speaker.getNationality());
    }

    @Override
    public void update(Speaker speaker) {
        final String SQL_UPDATE_PERSON = "update Person set " +
                "namePerson = ?, " +
                "lastname = ?, " +
                "mail = ?," +
                "typePerson = ?  where idPerson = ?";

        jdbcTemplate.update(SQL_UPDATE_PERSON,
                speaker.getPerson().getNamePerson(),
                speaker.getPerson().getLastname(),
                speaker.getPerson().getMail(),
                speaker.getPerson().getTypePerson(),
                speaker.getPerson().getIdPerson());

        final String SQL_UPDATE_SPEAKER = "update Speaker set " +
                "idPerson = ?," +
                "profession = ?," +
                "cellPhone = ?," +
                "descriptionSpeaker = ?," +
                "companyName = ?," +
                "nationality = ? where idSpeaker = ?";
        jdbcTemplate.update(SQL_UPDATE_SPEAKER,
                speaker.getPerson().getIdPerson(),
                speaker.getProfession(),
                speaker.getCellPhone(),
                speaker.getDescriptionSpeaker(),
                speaker.getCompanyName(),
                speaker.getNationality(),
                speaker.getIdSpeaker());
    }

    @Override
    public void delete(int idSpeaker) {
        final String SQL_DELETE = "delete from Speaker where idSpeaker = ?";
        jdbcTemplate.update(SQL_DELETE, idSpeaker);
    }

}
