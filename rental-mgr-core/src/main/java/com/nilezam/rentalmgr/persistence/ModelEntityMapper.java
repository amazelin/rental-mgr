package com.nilezam.rentalmgr.persistence;

public interface ModelEntityMapper<Model, Entity> {

    Model toModel(Entity from);

    Entity toEntity(Model from);

}
