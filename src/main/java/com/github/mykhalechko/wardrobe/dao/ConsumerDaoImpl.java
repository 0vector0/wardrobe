package com.github.mykhalechko.wardrobe.dao;

import com.github.mykhalechko.wardrobe.models.Consumer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class ConsumerDaoImpl implements ConsumerDao {

    private EntityManager entityManager;

    public ConsumerDaoImpl() {
        SessionFactory factory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = factory.createEntityManager();
    }

    private void openTransaction() {
        entityManager.getTransaction().begin();
    }

    private void closeTransaction() {
        entityManager.getTransaction().commit();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addConsumer(Consumer consumer) {
        openTransaction();
        entityManager.persist(consumer);
        closeTransaction();
    }

    public void updateConsumer(Consumer consumer) {
        openTransaction();
        entityManager.merge(consumer);
        closeTransaction();
    }

    public void removeConsumer(int id) {
        Consumer consumer = getConsumerById(id);
        if (consumer != null) {
            openTransaction();
            entityManager.remove(consumer);
            closeTransaction();
        }
    }

    public Consumer getConsumerById(int id) {
        return entityManager.find(Consumer.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Consumer> liConsumers() {
        openTransaction();
        List<Consumer> consumers = (List<Consumer>) entityManager.createQuery("FROM Consumer").getResultList();
        closeTransaction();
        return consumers;
    }
}
