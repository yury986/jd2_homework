package by.yury.data;

import org.hibernate.cfg.Configuration;

public class SessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                //Configuration conf = new Configuration();
                //conf.setPhysicalNamingStrategy(new MyPhysicalNamingStrategy());
                sessionFactory = (SessionFactory) new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}