package com.nilezam.rentalmgr.model.user;

import com.nilezam.rentalmgr.model.repository.AbstractJpaRepository;
import com.nilezam.rentalmgr.model.repository.Specification;
import com.nilezam.rentalmgr.model.repository.Repository;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Arnaud on 19/11/2017.
 */
@org.springframework.stereotype.Repository
public class UserRepository extends AbstractJpaRepository implements Repository<User> {


    public UserRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public User add(User user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPassword(user.getPassword());

        entityManagerFactory.createEntityManager().persist(userEntity);

        user = new User(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getLastName(), userEntity.getPassword());

        return user;
    }

    @Override
    public void remove(User object) {

    }

    @Override
    public Iterable<User> find(Specification specification) {
        return null;
    }
}
