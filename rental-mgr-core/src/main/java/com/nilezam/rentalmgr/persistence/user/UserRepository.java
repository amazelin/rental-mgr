package com.nilezam.rentalmgr.persistence.user;

import com.nilezam.rentalmgr.model.user.User;
import com.nilezam.rentalmgr.persistence.repository.AbstractJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Created by Arnaud on 19/11/2017.
 */
@Repository
@Transactional
public class UserRepository extends AbstractJpaRepository<User, UserEntity> {


    public UserRepository(EntityManager entityManager) {
        super(UserEntity.class, new UserMapper(), entityManager);
    }


}
