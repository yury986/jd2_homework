package by.yury.data.dao;

import by.yury.data.pojo.singleTable.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AnimalDaoImpl implements AnimalDao {

    private SessionFactory sessionFactory;

    public AnimalDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Animal getAnimalById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Arg id not be null");
        }
        Session session = null;
        Transaction transaction = null;
        Animal animal;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            animal = session.get(Animal.class, id); //Some work

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return animal;
    }


    @Override
    public String saveNewAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Arg Animal not be null");
        }
        Session session = null;
        Transaction transaction = null;
        String savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(animal);//Some
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
