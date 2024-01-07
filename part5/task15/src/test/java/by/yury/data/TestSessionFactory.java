package by.yury.data;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestSessionFactory {

    private static org.hibernate.SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration()
                        .configure("test.hibernate.cfg.xml")
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}

