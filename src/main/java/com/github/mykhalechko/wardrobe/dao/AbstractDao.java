package com.github.mykhalechko.wardrobe.dao;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

abstract class AbstractDao<E extends Serializable> implements DaoInterface<E> {

    private Class<E> clazz;
    private EntityManager entityManager;

    AbstractDao() {
        SessionFactory factory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = factory.createEntityManager();
    }

    final void setClazz(final Class<E> clazz) {
        this.clazz = clazz;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private void openTransaction() {
        entityManager.getTransaction().begin();
    }

    private void closeTransaction() {
        entityManager.getTransaction().commit();
    }


    public void add(E entity) {
        openTransaction();
        entityManager.persist(entity);
        closeTransaction();
    }

    public void update(E entity) {
        openTransaction();
        entityManager.merge(entity);
        closeTransaction();
    }

    public E findById(String id) {
        return (E) entityManager.find(clazz, id);
    }

    public void delete(E entity) {
        openTransaction();
        entityManager.remove(entity);
        closeTransaction();
    }

    public List<E> findAll() {
        openTransaction();
        List<E> eList = entityManager.createQuery("FROM " + clazz.getName()).getResultList();
        closeTransaction();
        return eList;
    }

    public void deleteAll() {
        List<E> eList = findAll();
        for (E e : eList) {
            delete(e);
        }
    }

}
