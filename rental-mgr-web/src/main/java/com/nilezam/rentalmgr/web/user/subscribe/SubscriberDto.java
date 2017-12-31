package com.nilezam.rentalmgr.web.user.subscribe;

import com.nilezam.rentalmgr.web.user.AbstractUserDto;

/**
 * Created by Arnaud on 19/11/2017.
 */
public class SubscriberDto extends AbstractUserDto {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
