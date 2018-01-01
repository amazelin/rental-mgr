package com.nilezam.rentalmgr.model.user;

import com.nilezam.rentalmgr.model.repository.AbstractJpaRepository;
import com.nilezam.rentalmgr.model.repository.HibernateSpecification;
import com.nilezam.rentalmgr.model.repository.Repository;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Arnaud on 19/11/2017.
 */
@org.springframework.stereotype.Repository
public class UserRepository extends AbstractJpaRepository<UserEntity>  {


    public UserRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }


       @Override
    public Iterable<UserEntity> find(HibernateSpecification specification) {
        return null;
    }
}
