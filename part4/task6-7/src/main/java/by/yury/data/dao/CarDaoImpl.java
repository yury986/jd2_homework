package by.yury.data.dao;

import by.yury.data.pojo.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CarDaoImpl implements CarDao {

    private  SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Car getCarById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Arg id not be null");
        }
        Session session = null;
        Transaction transaction = null;
        Car car;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            car = session.get(Car.class, id); //Some work

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return car;
    }


    @Override
    public String saveNewCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Arg car not be null");
        }
        Session session = null;
        Transaction transaction = null;
        String savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(car);//Some
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
    public boolean deleteCarById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Arg id not be null");
        }
        Session session = null;
        Transaction transaction = null;
        Car car;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            car = session.get(Car.class, id); //Some work
            if (car == null) {
                return false;
            }
            session.delete(car);
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
    public List<Car> readAll() {
        return null;

    }

}

