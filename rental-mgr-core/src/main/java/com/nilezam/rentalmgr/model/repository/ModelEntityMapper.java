package com.nilezam.rentalmgr.model.repository;

public interface ModelEntityMapper<M,E> {

    M toModel(E from);

    E toEntity(M from);

}
