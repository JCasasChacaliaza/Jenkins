package com.explora.team.lecture.domain;

import java.sql.Date;

public class Lecture {

    private String idLecture;
    private String title;
    private Date startDate;
    private Date endDate;

    public Lecture(String idLecture, String title, Date startDate, Date endDate) {
        this.idLecture = idLecture;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(String idLecture) {
        this.idLecture = idLecture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
