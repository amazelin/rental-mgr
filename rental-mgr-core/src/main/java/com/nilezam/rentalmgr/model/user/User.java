package com.nilezam.rentalmgr.model.user;

import java.util.Objects;

/**
 * Created by Arnaud on 19/11/2017.
 */
public class User  {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String mail;
    private final String password;


    public User(Long id, String firstName, String lastName, String mail, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(mail, user.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }
}
