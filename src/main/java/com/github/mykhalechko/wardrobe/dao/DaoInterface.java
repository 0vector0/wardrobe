package com.github.mykhalechko.wardrobe.dao;


import java.io.Serializable;
import java.util.List;

interface DaoInterface<E extends Serializable> {

    public void persist(E entity);

    public void update(E entity);

    public E findById(String id);

    public void delete(E entity);

    public List<E> findAll();

    public void deleteAll();

}