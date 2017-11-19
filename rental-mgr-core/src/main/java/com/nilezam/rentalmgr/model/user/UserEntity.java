package com.nilezam.rentalmgr.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Arnaud on 19/11/2017.
 */
@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String password;

    UserEntity() {
    }

    public Long getId() {
        return id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
