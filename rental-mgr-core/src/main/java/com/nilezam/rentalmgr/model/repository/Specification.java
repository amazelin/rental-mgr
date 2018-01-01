package com.nilezam.rentalmgr.model.repository;

import org.hibernate.criterion.Criterion;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

/**
 * Created by Arnaud on 05/02/2017.
 */
public interface Specification<M, E> {

    boolean isSpecifiedBy(M object);

    Predicate toPredicate(Root<E> object, CriteriaBuilder criteriaBuilder);
}
