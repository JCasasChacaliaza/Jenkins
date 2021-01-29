package com.explora.team.lecture.persistence;

import com.explora.team.lecture.domain.Lecture;
import com.explora.team.lecture.domain.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureImpl implements LectureRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Lecture> findAll() {
        final String SQL_GET_ALL = "select * from Lecture";
        return jdbcTemplate.query(SQL_GET_ALL, new LectureMapper());
    }

    @Override
    public List<Lecture> findTitle(String title){
        final String SQL_GET_ALL = "select * from Lecture  where upper(title) like " + "upper('" + title+ "%')";
        return jdbcTemplate.query(SQL_GET_ALL, new LectureMapper());
    }

    @Override
    public void save(Lecture lecture) {
        final String SQL_INSERT = "insert into Lecture (" +
                "idLecture," +
                "title," +
                "startDate," +
                "endDate) values (?, ?, ?, ?)";

        jdbcTemplate.update(SQL_INSERT,
                lecture.getIdLecture(),
                lecture.getTitle(),
                lecture.getStartDate(),
                lecture.getEndDate());
    }

    @Override
    public void update(Lecture lecture) {
        final String SQL_UPDATE = "update Lecture set " +
                "title = ?," +
                "startDate = ?," +
                "endDate = ? where idLecture = ?";

        jdbcTemplate.update(SQL_UPDATE,
                lecture.getTitle(),
                lecture.getStartDate(),
                lecture.getEndDate(),
                lecture.getIdLecture());
    }

    @Override
    public void delete(String idLecture) {
        final String SQL_DELETE = "delete from Lecture where idLecture =?";

        jdbcTemplate.update(SQL_DELETE, idLecture);
    }

}
