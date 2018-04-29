package com.nilezam.rentalmgr.persistence.repository;

/**
 * Created by Arnaud on 05/02/2017.
 */
public interface Repository<Model> {


    Model add(Model object);

    void remove(Model object);

    Model get(Long id);

    Model get(Specification specification);

    Iterable<Model> find(Specification specification);

    Iterable<Model> findAll();

}
