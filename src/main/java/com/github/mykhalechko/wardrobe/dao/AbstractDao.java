package com.github.mykhalechko.wardrobe.dao;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDao<T extends Serializable> implements DaoInterface<T> {

    private Class<T> clazz;
    private EntityManager entityManager;

    public AbstractDao() {
        SessionFactory factory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = factory.createEntityManager();
    }

    public final void setClazz(final Class<T> clazz) {
        this.clazz = clazz;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected void openTransaction() {
        entityManager.getTransaction().begin();
    }

    protected void closeTransaction() {
        entityManager.getTransaction().commit();
    }


    public void persist(T entity) {
        openTransaction();
        entityManager.persist(entity);
        closeTransaction();
    }

    public void update(T entity) {
        openTransaction();
        entityManager.merge(entity);
        closeTransaction();
    }

    public T findById(String id) {
        return (T) entityManager.find(clazz, id);
    }

    public void delete(T entity) {
        openTransaction();
        entityManager.remove(entity);
        closeTransaction();
    }

    public List<T> findAll() {
        openTransaction();
        List<T> tList = entityManager.createQuery("FROM " + clazz.getName()).getResultList();
        closeTransaction();
        return tList;
    }

    public void deleteAll() {
        List<T> tList = findAll();
        for (T t : tList) {
            delete(t);
        }
    }

}
