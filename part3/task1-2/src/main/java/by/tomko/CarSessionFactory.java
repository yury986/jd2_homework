package by.tomko;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CarSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){

        if (sessionFactory == null) {
            try {
                sessionFactory =  new Configuration()
                        .configure()
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return sessionFactory;
    }
}
