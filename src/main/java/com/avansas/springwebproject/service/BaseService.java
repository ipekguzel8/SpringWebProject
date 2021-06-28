package com.avansas.springwebproject.service;

import com.avansas.springwebproject.dao.BaseDao;
import com.avansas.springwebproject.entities.BaseEntity;

import java.util.List;

public class BaseService <E extends BaseEntity,D extends BaseDao>{
    D dao;

    public BaseService(D dao) {
        this.dao = dao;
    }

    public void save(E entity) {
        dao.save(entity);
    }

    public List<E> findAll() {
        return dao.findAll();
    }

    public void delete(E entity) {
        dao.delete(entity);
    }
    public E getById(Long id){
        return (E) dao.getById(id);
    }
}
