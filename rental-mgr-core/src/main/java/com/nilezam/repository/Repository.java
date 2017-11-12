package com.nilezam.repository;

/**
 * Created by Arnaud on 05/02/2017.
 */
public interface Repository<T> {


    T add(T object);

    void remove(T object);

    Iterable<T> find(Specification specification);
}
