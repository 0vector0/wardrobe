package com.github.mykhalechko.wardrobe.example;

import com.github.mykhalechko.wardrobe.models.Consumer;
import com.github.mykhalechko.wardrobe.models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();

        Session session = null;

//        session = sessionFactory.openSession();
//        session.beginTransaction();
//        Consumer consumer = new Consumer();
//        consumer.setFirstName("petro");
//        consumer.setEmail("petro@petro.com");
//        consumer.setPassword("123");
//        session.save(consumer);
//        session.getTransaction().commit();
//        session.close();
        Item item = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        item = new Item();
        item.setName("item1");
        item.setDescription("item 1 desctiption");
        item.setColor("item 1 color");
        session.save(item);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        item = new Item();
        item.setName("item2");
        item.setDescription("item 2 desctiption");
        item.setColor("item 2 color");
        session.save(item);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        item = new Item();
        item.setName("item3");
        item.setDescription("item 3 desctiption");
        item.setColor("item 3 color");
        session.save(item);
        session.getTransaction().commit();
        session.close();

//        session = sessionFactory.openSession();
//        session.beginTransaction();
//        consumer = new Consumer();
//        consumer.setFirstName("ivan");
//        consumer.setEmail("ivan@ivan.com");
//        consumer.setPassword("123");
//        session.save(consumer);
//        session.getTransaction().commit();
//        session.close();
    }
}
