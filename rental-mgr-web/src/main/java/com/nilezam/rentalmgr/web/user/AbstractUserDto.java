package com.nilezam.rentalmgr.web.user;

/**
 * Created by Arnaud on 19/11/2017.
 */
public class AbstractUserDto {

    private String firstName;
    private String lastName;
    private String mail;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
