package com.nilezam.rentalmgr.model.repository;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Arnaud on 05/02/2017.
 */
public abstract class AbstractJpaRepository {


    protected final EntityManagerFactory entityManagerFactory;

    public AbstractJpaRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }
}
