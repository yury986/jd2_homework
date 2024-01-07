package by.yury.data;

import org.hibernate.cfg.Configuration;

public class SessionFactory {

    private static org.hibernate.SessionFactory sessionFactory;

    public static org.hibernate.SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                //Configuration conf = new Configuration();
                //conf.setPhysicalNamingStrategy(new MyPhysicalNamingStrategy());
                sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
