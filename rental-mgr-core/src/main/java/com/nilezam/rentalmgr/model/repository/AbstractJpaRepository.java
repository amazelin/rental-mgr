package com.nilezam.rentalmgr.model.repository;

import com.nilezam.rentalmgr.model.IdentifierBehavior;
import com.nilezam.rentalmgr.model.user.User;
import com.nilezam.rentalmgr.model.user.UserEntity;

import javax.persistence.EntityManagerFactory;

/**
 * Created by Arnaud on 05/02/2017.
 */
public abstract class AbstractJpaRepository<M extends IdentifierBehavior, E extends IdentifierBehavior> implements Repository<M> {

    private final Class<E> entityClass;
    protected final ModelEntityMapper<M,E> mapper;
    protected final EntityManagerFactory entityManagerFactory;


    public AbstractJpaRepository(Class<E> clazz, ModelEntityMapper<M,E> mapper, EntityManagerFactory entityManagerFactory){
        this.entityClass = clazz;
        this.mapper = mapper;
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public M add(M model) {
        entityManagerFactory.createEntityManager().persist(model);
        return model;
    }

    @Override
    public void remove(M model) {
        E entity = entityManagerFactory.createEntityManager().find(entityClass, model.getId());

        if (entity != null)
            entityManagerFactory.createEntityManager().remove(entity);

    }


    @Override
    public M get(Long id) {
        return mapper.toModel(entityManagerFactory.createEntityManager().find(entityClass, id));
    }


}
