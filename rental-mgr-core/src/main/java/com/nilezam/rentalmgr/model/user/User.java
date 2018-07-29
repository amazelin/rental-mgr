package com.nilezam.rentalmgr.model.user;

import com.nilezam.rentalmgr.persistence.IdentifierBehavior;

import java.util.Objects;

/**
 * Created by Arnaud on 19/11/2017.
 */
public class User implements IdentifierBehavior {

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

    public User(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.mail = builder.mail;
        this.password = builder.password;
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
    
    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String mail;
        private String password;


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
