package com.explora.team.presentation.domain;

import com.explora.team.lecture.domain.Lecture;

import java.util.Date;

public class Presentation {

    private String idPresentation;
    private Lecture lecture;
    private Date dayPresentation;
    private String theme;
    private String descriptionPresentation;
    private int typePresentation;
    private String videoLink;

    public Presentation(String idPresentation, Lecture lecture, Date dayPresentation, String theme, String descriptionPresentation, int typePresentation, String videoLink) {
        this.idPresentation = idPresentation;
        this.lecture = lecture;
        this.dayPresentation = dayPresentation;
        this.theme = theme;
        this.descriptionPresentation = descriptionPresentation;
        this.typePresentation = typePresentation;
        this.videoLink = videoLink;
    }

    public String getIdPresentation() {
        return idPresentation;
    }

    public void setIdPresentation(String idPresentation) {
        this.idPresentation = idPresentation;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Date getDayPresentation() {
        return dayPresentation;
    }

    public void setDayPresentation(Date dayPresentation) {
        this.dayPresentation = dayPresentation;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescriptionPresentation() {
        return descriptionPresentation;
    }

    public void setDescriptionPresentation(String descriptionPresentation) {
        this.descriptionPresentation = descriptionPresentation;
    }

    public int getTypePresentation() {
        return typePresentation;
    }

    public void setTypePresentation(int typePresentation) {
        this.typePresentation = typePresentation;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    @Override
    public String toString() {
        return "Presentation{" +
                "idPresentation=" + idPresentation +
                ", lecture=" + lecture +
                ", dayPresentation=" + dayPresentation +
                ", theme='" + theme + '\'' +
                ", descriptionPresentation='" + descriptionPresentation + '\'' +
                ", typePresentation=" + typePresentation +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }

}
