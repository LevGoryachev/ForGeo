package ru.goryachev.forgeo.services;

import ru.goryachev.forgeo.entities.BaseEntity;

import java.util.List;

public interface ForGeoService {

    List getAll();

    BaseEntity getById(int id);

    BaseEntity getByName(String name);

    void create(BaseEntity entity);

    void update (BaseEntity entity);

    void delete (int id);

}
