package by.yury.data.dao;

import by.yury.data.pojo.Car;
import by.yury.data.pojo.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OwnerDaoImpl implements OwnerDao {

    private final SessionFactory sessionFactory;

    public OwnerDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Owner getOwnerById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Arg id not be null");
        }
        Session session = null;
        Transaction transaction = null;
        Owner owner;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            owner = session.get(Owner.class, id); //Some work

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return owner;
    }


    @Override
    public String saveNewOwner(Owner owner) {
        if (owner == null) {
            throw new IllegalArgumentException("Arg car not be null");
        }
        Session session = null;
        Transaction transaction = null;
        String savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(owner);//Some
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return savedId;
    }

    @Override
    public boolean deleteOwnerById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Arg id not be null");
        }
        Session session = null;
        Transaction transaction = null;
        Owner owner;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            owner = session.get(Owner.class, id); //Some work
            if (owner == null) {
                return false;
            }
            session.delete(owner);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return true;
    }


    @Override
    public List<Owner> readAll() {
        return null;

    }

}
