package com.nilezam.rentalmgr.model.repository;

import org.hibernate.criterion.Criterion;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

/**
 * Created by Arnaud on 05/02/2017.
 */
public interface Specification<T> {

    boolean isSpecifiedBy(T object);

    Predicate toPredicate(Root<T> object, CriteriaBuilder criteriaBuilder);
}
