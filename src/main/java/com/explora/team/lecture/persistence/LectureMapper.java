package com.explora.team.lecture.persistence;

import com.explora.team.lecture.domain.Lecture;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LectureMapper implements RowMapper<Lecture> {

    @Override
    public Lecture mapRow(ResultSet rs, int rowsNum) throws SQLException {
        return new Lecture(
                rs.getString("idLecture"),
                rs.getString("title"),
                rs.getDate("startDate"),
                rs.getDate("endDate")
        );
    }

}
