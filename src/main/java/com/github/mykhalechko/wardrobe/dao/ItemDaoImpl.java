package com.github.mykhalechko.wardrobe.dao;

import com.github.mykhalechko.wardrobe.models.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {


    private EntityManager entityManager;

//    public ItemDaoImpl() {
//        SessionFactory factory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
//        entityManager = factory.createEntityManager();
//    }

    //    private void openTransaction() {
//        entityManager.getTransaction().begin();
//    }
//
//    private void closeTransaction() {
//        entityManager.getTransaction().commit();
//    }

    @PersistenceContext(unitName = "WardrobeManagement", type = PersistenceContextType.EXTENDED)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void addItem(Item item) {
//        openTransaction();
        entityManager.persist(item);
//        closeTransaction();
    }

    @Transactional
    public void updateItem(Item item) {
//        openTransaction();
        entityManager.merge(item);
//        closeTransaction();
    }

    @Transactional
    public void removeItem(int id) {
        Item item = getItemById(id);
        if (item != null) {
//            openTransaction();
            entityManager.remove(item);
//            closeTransaction();
        }
    }

    public Item getItemById(int id) {
        return entityManager.find(Item.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Item> listItems() {
//        openTransaction();
        List<Item> items = entityManager.createQuery("FROM Item", Item.class).getResultList();
//        closeTransaction();
        return items;
    }
}
