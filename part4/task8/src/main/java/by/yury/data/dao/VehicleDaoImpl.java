package by.yury.data.dao;

import by.yury.data.pojo.tablePerClass.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class VehicleDaoImpl implements VehicleDao {

    private SessionFactory sessionFactory;

    public VehicleDaoImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Vehicle getVehicleById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Arg id not be null");
        }
        Session session = null;
        Transaction transaction = null;
        Vehicle vehicle;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            vehicle = session.get(Vehicle.class, id); //Some work

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return vehicle;
    }


    @Override
    public String saveNewVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Arg Vehicle not be null");
        }
        Session session = null;
        Transaction transaction = null;
        String savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (String) session.save(vehicle);//Some
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
