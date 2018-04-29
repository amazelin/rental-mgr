package com.nilezam.rentalmgr.persistence.user;

import com.nilezam.rentalmgr.persistence.IdentifierBehavior;

import javax.persistence.*;

/**
 * Created by Arnaud on 19/11/2017.
 */
@Entity
@Table(name = "user")
public class UserEntity implements IdentifierBehavior {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String firstName;

    private String lastName;

    private String mail;

    public UserEntity() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    private String password;

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
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


    public enum Columns {
        ID("id"),
        FIRSTNAME("firstName"),
        LASTNAME("lastName"),
        MAIL("mail"),
        PASSWORD("password");

        private final String label;

        Columns(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }
}
