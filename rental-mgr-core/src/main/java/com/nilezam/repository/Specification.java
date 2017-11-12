package com.nilezam.repository;

/**
 * Created by Arnaud on 05/02/2017.
 */
public interface Specification<T> {


    boolean isSpecifiedBy(T object);
}
