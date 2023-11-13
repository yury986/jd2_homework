package by.tomko.data;

import by.tomko.CarDataSource;

import by.tomko.data.Dao.CarDao;
import by.tomko.data.Dao.CarDaoImpl;
import by.tomko.data.pojo.Car;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.UUID;

public class CarRunner {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String PeugeotId = UUID.randomUUID().toString(); // task2
        Car newCarPeugeot = new Car(PeugeotId, "Peugeot", "Blue", "15000");
        String carPeugeot = new CarDaoImpl().saveNewCar(newCarPeugeot);

        CarDao carDao = new CarDaoImpl(); //task2

        Car car = carDao.getCarById(PeugeotId);   //task2
        System.out.println(car.getModel());

        Car car2 = carDao.loadCarById(PeugeotId);  //task2
        System.out.println(car2.getModel());
        System.out.println("+++++++++++++");




        Connection conn = CarDataSource.getConnection();
        conn.createStatement().executeUpdate(
                " CREATE DEFINER=`root`@`localhost` TRIGGER `car_BEFORE_INSERT` BEFORE INSERT ON `car` FOR EACH ROW BEGIN\n" +
                        "set new.model = 'BWM';\n" +
                        "END");

          String RenoId = UUID.randomUUID().toString();
          Car newCarReno = new Car(RenoId, "Reno", "Grey", "5000");

          String carReno = new CarDaoImpl().saveNewCar(newCarReno);

          CarDaoImpl carRef = new CarDaoImpl();
          carRef.refreshCar(RenoId, "Reno");


          Boolean result = carDao.deleteCarById(RenoId);
          System.out.println(result);


    }
}


