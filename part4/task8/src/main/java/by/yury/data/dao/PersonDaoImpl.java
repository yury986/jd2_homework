package by.yury.data.dao;

import by.yury.data.pojo.joined.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonDaoImpl implements PersonDao {

     SessionFactory sessionFactory;

    public PersonDaoImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }


    @Override
    public String saveNewPerson(Person person) {
        Session session = null;
        Transaction transaction = null;
        String savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(person);//Some work
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
    public Person getPersonById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Arg id not be null");
        }
        Session session = null;
        Transaction transaction = null;
        Person person;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            person = session.get(Person.class, id); //Some work

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return person;
    }


}
