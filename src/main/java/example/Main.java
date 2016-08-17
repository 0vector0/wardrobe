package example;

import media.AppUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        AppUser user = new AppUser("firstuser");
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}
