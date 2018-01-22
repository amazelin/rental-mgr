package com.nilezam.rentalmgr.model.user;

import com.nilezam.rentalmgr.model.repository.AbstractJpaRepository;
import com.nilezam.rentalmgr.model.repository.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arnaud on 19/11/2017.
 */
@Repository
@Transactional
public class UserRepository extends AbstractJpaRepository<User, UserEntity>  {


    public UserRepository(EntityManager entityManager) {
        super(UserEntity.class, new UserMapper(), entityManager);
    }


    @Override
    public User get(Specification specification) {
        return mapper.toModel(getTypedQuery(specification).getSingleResult());
    }

    @Override
    public Iterable<User> find(Specification specification) {
        Set<User> users = new HashSet<>();

        for (UserEntity userEntity : getTypedQuery(specification).getResultList())
            users.add(mapper.toModel(userEntity));

        return users;
    }

    private TypedQuery<UserEntity> getTypedQuery(Specification specification) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = criteriaBuilder
                .createQuery(UserEntity.class);
        final Root<UserEntity> from = query.from(UserEntity.class);
        query.select(from).where(specification.toPredicate(from, criteriaBuilder));

        return em.createQuery(query);

    }
}
