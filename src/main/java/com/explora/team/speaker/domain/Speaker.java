package com.explora.team.speaker.domain;

public class Speaker {

    private String idSpeaker;
    private Person person;
    private String profession;
    private String cellPhone;
    private String descriptionSpeaker;
    private String companyName;
    private String nationality;

    public Speaker(String idSpeaker, Person person, String profession, String cellPhone, String descriptionSpeaker, String companyName, String nationality) {
        this.idSpeaker = idSpeaker;
        this.person = person;
        this.profession = profession;
        this.cellPhone = cellPhone;
        this.descriptionSpeaker = descriptionSpeaker;
        this.companyName = companyName;
        this.nationality = nationality;
    }

    public String getIdSpeaker() {
        return idSpeaker;
    }

    public void setIdSpeaker(String idSpeaker) {
        this.idSpeaker = idSpeaker;
    }

    public Person getPerson() {
        return person;
    }

    public void setIdPerson(Person Person) {
        this.person = Person;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getDescriptionSpeaker() {
        return descriptionSpeaker;
    }

    public void setDescriptionSpeaker(String descriptionSpeaker) {
        this.descriptionSpeaker = descriptionSpeaker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
