package utils;


import models.old.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;


/**
 * @author vector
 */
public class HibernateFirst {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure(new File("hibernate.cfg.xml")).build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session s = sessionFactory.openSession();
            s.beginTransaction();
            Type t = new Type();
            t.setTypeName("Стол");
            s.save(t);
            s.getTransaction().commit();
            s.close();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            ex.printStackTrace();
        } finally {
            sessionFactory.close();
        }

    }

}


