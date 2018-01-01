package com.nilezam.rentalmgr.model.repository;

import org.hibernate.criterion.Criterion;

/**
 * Created by Arnaud on 05/02/2017.
 */
public interface HibernateSpecification<T> {


    Criterion toCriteria(T object);
}
