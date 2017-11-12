package com.nilezam.rentalmgr.repository;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Arnaud on 05/02/2017.
 */
public abstract class AbstractJpaRepository<T> implements Repository<T> {


    private final EntityManagerFactory entityManagerFactory;

    public AbstractJpaRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public T add(T object) {
        this.entityManagerFactory.createEntityManager().persist(object);
        return object;
    }

    @Override
    public void remove(T object) {
        this.entityManagerFactory.createEntityManager().remove(object);

    }

    @Override
    public Iterable<T> find(Specification specification) {
        return null;
    }
}
