package com.nilezam.rentalmgr.model.repository;

import com.nilezam.rentalmgr.model.IdentifierBehavior;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arnaud on 05/02/2017.
 */
@Transactional
public abstract class AbstractJpaRepository<Model extends IdentifierBehavior, Entity extends IdentifierBehavior> implements Repository<Model> {

    private final Class<Entity> entityClass;
    protected final ModelEntityMapper<Model, Entity> mapper;
    protected final EntityManager em;


    public AbstractJpaRepository(Class<Entity> clazz, ModelEntityMapper<Model, Entity> mapper, EntityManager entityManager){
        this.entityClass = clazz;
        this.mapper = mapper;
        this.em = entityManager;
    }

    @Override
    @Transactional
    public Model add(Model model) {
        Entity entity = mapper.toEntity(model);
        em.persist(entity);
        return mapper.toModel(entity);
    }

    @Override
    @Transactional
    public void remove(Model model) {
        Entity entity = em.find(entityClass, model.getId());

        if (entity != null)
            em.remove(entity);

    }


    @Override
    public Model get(Long id) {
        return mapper.toModel(em.find(entityClass, id));
    }

    @Override
    public Iterable<Model> findAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Entity> query = criteriaBuilder
                .createQuery(entityClass);
        final Root<Entity> from = query.from(entityClass);
        query.select(from);

        Set<Model> resultSets = new HashSet<>();

        for (Entity entity : em.createQuery(query).getResultList())
            resultSets.add(mapper.toModel(entity));

        return resultSets;
    }
}
