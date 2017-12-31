package com.nilezam.rentalmgr.web.user;

/**
 * Created by Arnaud on 19/11/2017.
 */
public final class UserDto extends AbstractUserDto {

    private Long id;

    public UserDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
