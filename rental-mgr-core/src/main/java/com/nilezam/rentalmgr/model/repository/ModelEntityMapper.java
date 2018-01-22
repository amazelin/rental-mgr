package com.nilezam.rentalmgr.model.repository;

public interface ModelEntityMapper<Model, Entity> {

    Model toModel(Entity from);

    Entity toEntity(Model from);

}
