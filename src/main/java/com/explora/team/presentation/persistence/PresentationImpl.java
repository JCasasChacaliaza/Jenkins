package com.explora.team.presentation.persistence;

import com.explora.team.presentation.domain.Presentation;
import com.explora.team.presentation.domain.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PresentationImpl implements PresentationRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Presentation> findAll() {
        final String SQL_GET_ALL = "select" +
                "   pt.idPresentation, lt.idLecture," +
                "   lt.title, lt.startDate, lt.endDate," +
                "   pt.dayPresentation, pt.theme," +
                "   pt.descriptionPresentation, pt.typePresentation," +
                "   pt.videoLink " +
                "from lecture lt " +
                "   inner join presentation pt" +
                "       on pt.idLecture = lt.idLecture";
        return jdbcTemplate.query(SQL_GET_ALL, new PresentationMapper());
    }

    @Override
    public void save(Presentation presentation) {
        final String SQL_INSERT_LECTURE = "insert into Lecture (" +
                "idLecture," +
                "title," +
                "startDate," +
                "endDate) values (?, ?, ?, ?)";

        jdbcTemplate.update(SQL_INSERT_LECTURE,
                presentation.getLecture().getIdLecture(),
                presentation.getLecture().getTitle(),
                presentation.getLecture().getStartDate(),
                presentation.getLecture().getEndDate());

        final String SQL_INSERT_PRESENTATION = "insert into Presentation (" +
                "idPresentation," +
                "idLecture," +
                "dayPresentation," +
                "theme," +
                "descriptionPresentation," +
                "typePresentation," +
                "videoLink) values (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(SQL_INSERT_PRESENTATION,
                presentation.getIdPresentation(),
                presentation.getLecture().getIdLecture(),
                presentation.getDayPresentation(),
                presentation.getTheme(),
                presentation.getDescriptionPresentation(),
                presentation.getTypePresentation(),
                presentation.getVideoLink());
    }

    @Override
    public void update(Presentation presentation) {
        final String SQL_UPDATE_LECTURE = "update Lecture set " +
                "title = ?," +
                "startDate = ?," +
                "endDate = ? where idLecture = ?";

        jdbcTemplate.update(SQL_UPDATE_LECTURE,
                presentation.getLecture().getTitle(),
                presentation.getLecture().getStartDate(),
                presentation.getLecture().getEndDate(),
                presentation.getLecture().getIdLecture());

        final String SQL_UPDATE = "update Presentation set " +
                "idLecture = ?," +
                "dayPresentation = ?," +
                "theme = ?," +
                "descriptionPresentation = ?," +
                "typePresentation = ?," +
                "videoLink = ? where idPresentation = ?";

        jdbcTemplate.update(SQL_UPDATE,
                presentation.getLecture().getIdLecture(),
                presentation.getDayPresentation(),
                presentation.getTheme(),
                presentation.getDescriptionPresentation(),
                presentation.getTypePresentation(),
                presentation.getVideoLink(),
                presentation.getIdPresentation());
    }

    @Override
    public void delete(String idPresentation) {
        final String SQL_DELETE = "delete from Presentation where idPresentation = ?";
        jdbcTemplate.update(SQL_DELETE, idPresentation);
    }

}
