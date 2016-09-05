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

    @PersistenceContext(unitName = "WardrobeManagement", type = PersistenceContextType.EXTENDED)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void addItem(Item item) {
        entityManager.persist(item);
    }

    @Transactional
    public void updateItem(Item item) {
        entityManager.merge(item);
    }

    @Transactional
    public void removeItem(int id) {
        Item item = getItemById(id);
        if (item != null) {
            entityManager.remove(item);
        }
    }

    public Item getItemById(int id) {
        return entityManager.find(Item.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Item> listItems() {
        List<Item> items = entityManager.createQuery("FROM Item", Item.class).getResultList();
        return items;
    }
}
