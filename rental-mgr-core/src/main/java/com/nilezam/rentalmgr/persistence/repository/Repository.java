package com.nilezam.rentalmgr.persistence.repository;

import java.util.Optional;

/**
 * Created by Arnaud on 05/02/2017.
 */
public interface Repository<Model> {


    Model add(Model object);

    void remove(Model object);

    Optional<Model> get(Long id);

    Optional<Model> get(Specification specification);

    Iterable<Model> find(Specification specification);

    Iterable<Model> findAll();

}
