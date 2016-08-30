package com.github.mykhalechko.wardrobe.dao;

import com.github.mykhalechko.wardrobe.models.Item;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;


public class ItemDao implements ItemDaoInterface<Item, String> {

    private EntityManager entityManager;

    public ItemDao() {
        SessionFactory factory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = factory.createEntityManager();
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

    public void persist(Item entity) {
//        entityManager.getTransaction().begin();
        openTransaction();
        entityManager.persist(entity);
        closeTransaction();
//        entityManager.getTransaction().commit();
    }

    public void update(Item entity) {
        openTransaction();
        entityManager.merge(entity);
        closeTransaction();
    }

    public Item findById(String id) {
        entityManager.find(Item.class, id);
        return null;
    }

    public void delete(Item entity) {
        openTransaction();
        entityManager.remove(entity);
        closeTransaction();
    }

    public List<Item> findAll() {
        openTransaction();
        List<Item> items = entityManager.createQuery("SELECT E FROM Item E").getResultList();
        closeTransaction();
        return items;
    }

    public void deleteAll() {
        List<Item> items = findAll();
        for (Item item : items) {
            delete(item);
        }
    }
}
