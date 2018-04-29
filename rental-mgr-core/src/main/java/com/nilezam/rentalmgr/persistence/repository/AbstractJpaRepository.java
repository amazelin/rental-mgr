package com.nilezam.rentalmgr.persistence.repository;

import com.nilezam.rentalmgr.persistence.IdentifierBehavior;
import com.nilezam.rentalmgr.persistence.ModelEntityMapper;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * Created by Arnaud on 05/02/2017.
 */
@Transactional
public abstract class AbstractJpaRepository<Model extends IdentifierBehavior, Entity extends IdentifierBehavior> implements Repository<Model> {

    private final Class<Entity> entityClass;
    private final ModelEntityMapper<Model, Entity> mapper;
    private final EntityManager em;


    public AbstractJpaRepository(Class<Entity> clazz, ModelEntityMapper<Model, Entity> mapper, EntityManager entityManager){
        this.entityClass = clazz;
        this.mapper = mapper;
        this.em = entityManager;
    }

    @Override
    public Model get(Specification specification) {
        return mapper.toModel(getTypedQuery(specification).getSingleResult());
    }

    @Override
    public Iterable<Model> find(Specification specification) {
        final List<Entity> resultList = getTypedQuery(specification).getResultList();
        return resultList.stream().map(mapper::toModel).collect(toList());
    }

    private TypedQuery<Entity> getTypedQuery(Specification specification) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Entity> query = criteriaBuilder.createQuery(entityClass);

        final Root<Entity> from = query.from(entityClass);
        query.select(from).where(specification.toPredicate(from, criteriaBuilder));

        return em.createQuery(query);
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
        final Entity entity = em.find(entityClass, id);
        if (entity != null) {
            return mapper.toModel(entity);
        }

        return null;
    }

    @Override
    public Iterable<Model> findAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Entity> query = criteriaBuilder
                .createQuery(entityClass);
        final Root<Entity> from = query.from(entityClass);
        query.select(from);

        Set<Model> resultSets = new HashSet<>();

        em.createQuery(query).getResultList().forEach(entity -> resultSets.add(mapper.toModel(entity)));

        return resultSets;
    }
}
