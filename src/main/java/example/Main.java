package example;

import models.Consumer;
import models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();

        Session session = null;

        session = sessionFactory.openSession();
        session.beginTransaction();
        Consumer consumer = new Consumer();
        consumer.setFirstName("petro");
        consumer.setEmail("petro@petro.com");
        consumer.setPassword("123");
        session.save(consumer);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setName("item1");
        session.save(item);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        consumer = new Consumer();
        consumer.setFirstName("ivan");
        consumer.setEmail("ivan@ivan.com");
        consumer.setPassword("123");
        session.save(consumer);
        session.getTransaction().commit();
        session.close();
    }
}
