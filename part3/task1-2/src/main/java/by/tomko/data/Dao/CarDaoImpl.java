package by.tomko.data.Dao;

import by.tomko.CarDataSource;
import by.tomko.CarSessionFactory;
import by.tomko.data.pojo.Car;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CarDaoImpl implements CarDao {

    @Override
    public Car refreshCar(String id, Car car) {
        if (id == null){
            throw new IllegalArgumentException("Arg id not be null");
        }

        if (car == null){
            throw new IllegalArgumentException("Arg car not be null");
        }
        Session session = null;
        Transaction transaction = null;

        try {
            session = CarSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.clear();

            session.refresh(car); //Some work


        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return car;
    }


        @Override
    public Car getCarById(String id) {
            if (id == null){
                throw new IllegalArgumentException("Arg id not be null");
            }
        Session session = null;
        Transaction transaction = null;
        Car car;
        try {
            session = CarSessionFactory.getSessionFactory().openSession();
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
    public Car loadCarById(String id){
        if (id == null){
            throw new IllegalArgumentException("Arg id not be null");
        }
        Session session = null;
        Transaction transaction = null;
        Car car;
        try {
            session = CarSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            car = session.load(Car.class, id); //Some work
            car.getId();
            car.getModel();
            car.getColor();
            car.getPrice();

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
    public  String saveNewCar(Car car) {
        if (car == null){
            throw new IllegalArgumentException("Arg car not be null");
        }
        Session session = null;
        Transaction transaction = null;
        String savedId;
        try {
            session = CarSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(car);//Some work
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
        if (id == null){
            throw new IllegalArgumentException("Arg id not be null");
        }
        Session session = null;
        Transaction transaction = null;
        Car car;
        try {
            session = CarSessionFactory.getSessionFactory().openSession();
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
    public Car findCarById(String id) {
        if (id == null){
            throw new IllegalArgumentException("Arg id not be null");
        }
        Session session = null;
        Transaction transaction = null;
        Car car;
        try {
            session = CarSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            car = session.find(Car.class, id); //Some work

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
    public List<Car> readAll() {
        return null;
    }
}
