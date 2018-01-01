package com.nilezam.rentalmgr.model.repository;

import com.nilezam.rentalmgr.model.user.UserEntity;
import com.sun.org.apache.xpath.internal.axes.PredicatedNodeTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

/**
 * Created by Arnaud on 05/02/2017.
 */
public abstract class AbstractJpaRepository<T> implements Repository<T> {

    protected final EntityManagerFactory entityManagerFactory;

    public AbstractJpaRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public T add(T object) {
        entityManagerFactory.createEntityManager().persist(object);
        return object;
    }

    @Override
    public void remove(T object) {
        entityManagerFactory.createEntityManager().remove(object);
    }

    @Override
    public Iterable<T> find(HibernateSpecification specification) {
        entityManagerFactory.createEntityManager().getCriteriaBuilder();

        return null;
    }
}
