package com.explora.team.presentation.persistence;

import com.explora.team.lecture.domain.Lecture;
import com.explora.team.presentation.domain.Presentation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PresentationMapper implements RowMapper<Presentation> {

    @Override
    public Presentation mapRow(ResultSet rs, int rowsNum) throws SQLException {
        return new Presentation(
                rs.getString("idPresentation"),
                new Lecture(
                        rs.getString("idLecture"),
                        rs.getString("title"),
                        rs.getDate("startDate"),
                        rs.getDate("endDate")
                ),
                rs.getDate("dayPresentation"),
                rs.getString("theme"),
                rs.getString("descriptionPresentation"),
                rs.getInt("typePresentation"),
                rs.getString("videoLink")
        );
    }

}
