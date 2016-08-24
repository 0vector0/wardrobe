package com.github.mykhalechko.wardrobe.dao;

import com.github.mykhalechko.wardrobe.models.Item;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class ItemDao implements ItemDaoInterface<Item, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public ItemDao() {
    }

    private static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }


    public void persist(Item entity) {
        getCurrentSession().save(entity);
    }

    public void update(Item entity) {
        getCurrentSession().update(entity);
    }

    public Item findById(String id) {
        Item item = (Item) getCurrentSession().get(Item.class, id);
        return item;
    }

    public void delete(Item entity) {
        getCurrentSession().delete(entity);
    }

    public List<Item> findAll() {
        //TODO criteria vs HQL
        Criteria criteria = getCurrentSession().createCriteria(Item.class);
        List<Item> items = (List<Item>) criteria.list();

//        List items =  getCurrentSession().createQuery("from Item").list();
        return items;
    }

    public void deleteAll() {
        List<Item> entityList = findAll();
        for (Item entity : entityList) {
            delete(entity);
        }

    }
}
