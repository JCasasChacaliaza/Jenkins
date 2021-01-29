package com.explora.team.person.domain;

public class Person {

    private String idPerson;
    private String namePerson;
    private String lastname;
    private String mail;
    private int typePerson;
    private String userName;
    private String userPassword;

    public Person(String idPerson, String namePerson, String lastname) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.lastname = lastname;
    }

    public Person(String idPerson, String namePerson, String lastname, String mail, int typePerson, String userName, String userPassword) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.lastname = lastname;
        this.mail = mail;
        this.typePerson = typePerson;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(int typePerson) {
        this.typePerson = typePerson;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
