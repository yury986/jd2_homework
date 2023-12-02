package by.yury.data;

import by.yury.data.dao.CarDaoImpl;
import by.yury.data.dao.OwnerDaoImpl;
import by.yury.data.pojo.Address;
import by.yury.data.pojo.Car;
import by.yury.data.pojo.Owner;
import by.yury.data.pojo.TechnicalCertificate;
import org.hibernate.Session;


public class Main {


    public static void main(String[] args) {


        Car car = new Car(null, "BMW", "Blue", "15000",
                new TechnicalCertificate("454", "MMA", "2005", "8489 MH-7"));
        String carDao = new CarDaoImpl(ShowroomSessionFactory.getSessionFactory()).saveNewCar(car);


        Owner owner = new Owner(null, "Yury", "Petrov", "22.08.2022",
                new Address("Krasnaya", "Minsk", "200_004"));

        String ownerDao = new OwnerDaoImpl(ShowroomSessionFactory.getSessionFactory()).saveNewOwner(owner);

        try (Session session = ShowroomSessionFactory.getSessionFactory().openSession()) {
            session.refresh(car);
            session.refresh(owner);
            System.out.println(session.getIdentifier(car));
            System.out.println(session.getIdentifier(owner));

        }


    }
}
