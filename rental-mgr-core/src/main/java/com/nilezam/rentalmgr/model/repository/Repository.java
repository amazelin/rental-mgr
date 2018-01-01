package com.nilezam.rentalmgr.model.repository;

/**
 * Created by Arnaud on 05/02/2017.
 */
public interface Repository<B> {


    B add(B object);

    void remove(B object);

    B get(Long id);

    B get(Specification specification);

    Iterable<B> find(Specification specification);


}
