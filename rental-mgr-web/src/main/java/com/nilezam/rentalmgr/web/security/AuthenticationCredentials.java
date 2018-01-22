package com.nilezam.rentalmgr.web.security;

import java.util.Objects;

/**
 * Created by Arnaud on 27/11/2017.
 */
public class AuthenticationCredentials {

    private String login;
    private String password;

    public AuthenticationCredentials() {
    }

    public AuthenticationCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthenticationCredentials that = (AuthenticationCredentials) o;
        return Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
