package example;

import media.AppUser;
import models.Consumer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Consumer consumer = new Consumer();

//        AppUser user = new AppUser("firstuser");
        consumer.setFirstName("petro");
        consumer.setEmail("petro@petro.com");
        consumer.setPassword("123");
        session.save(consumer);

        session.getTransaction().commit();
        session.close();
    }
}
