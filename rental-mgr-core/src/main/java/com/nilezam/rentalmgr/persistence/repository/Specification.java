package com.nilezam.rentalmgr.persistence.repository;

import com.nilezam.rentalmgr.persistence.IdentifierBehavior;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by Arnaud on 05/02/2017.
 */
public interface Specification<Model extends IdentifierBehavior, Entity extends IdentifierBehavior> {

    boolean isSpecifiedBy(Model object);

    Predicate toPredicate(Root<Entity> object, CriteriaBuilder criteriaBuilder);
}
