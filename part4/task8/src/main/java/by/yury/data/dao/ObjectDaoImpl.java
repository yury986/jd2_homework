package by.yury.data.dao;

import by.yury.data.InheritanceSessionFactory;
import by.yury.data.pojo.joined.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ObjectDaoImpl implements ObjectDao {

    private SessionFactory sessionFactory;

    public ObjectDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Object getObjectById(Object object) {

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return object;
    }



    @Override
    public String saveNewObject(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Arg Object not be null");
        }
        Session session = null;
        Transaction transaction = null;
        String savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(object);//Some
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return savedId;
    }

}
