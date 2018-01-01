package com.nilezam.rentalmgr.model.user;

import com.nilezam.rentalmgr.model.repository.ModelEntityMapper;

public class UserMapper implements ModelEntityMapper<User, UserEntity> {


    @Override
    public User toModel(UserEntity from) {
        return new User(from.getId(), from.getFirstName(), from.getLastName(), from.getMail(), from
                .getPassword());
    }

    @Override
    public UserEntity toEntity(User from) {
        return null;
    }
}

