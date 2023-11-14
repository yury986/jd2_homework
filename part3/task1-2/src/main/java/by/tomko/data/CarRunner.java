package by.tomko.data;

import by.tomko.CarDataSource;

import by.tomko.data.Dao.CarDao;
import by.tomko.data.Dao.CarDaoImpl;
import by.tomko.data.pojo.Car;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.UUID;

import static java.lang.Integer.parseInt;

public class CarRunner {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        String PeugeotId = UUID.randomUUID().toString(); // task2
        Car newCarPeugeot = new Car(PeugeotId, "Peugeot", "Blue", "15000");
        String carPeugeot = new CarDaoImpl().saveNewCar(newCarPeugeot);

        CarDao carDao = new CarDaoImpl(); //task2

        Car car = carDao.getCarById(PeugeotId);
        System.out.println(car.getModel());

        Car car2 = carDao.loadCarById(PeugeotId);
        System.out.println(car2.getModel());
        System.out.println("++++++");

          String RenoId = UUID.randomUUID().toString();  //task3
          Car newCarReno = new Car(RenoId, "Reno", "Grey", "-5000");

          createTriggerNds(newCarReno);
          Car car1  = carDao.refreshCar(RenoId, newCarReno);
          System.out.println(car1.getPrice());


          Boolean result = carDao.deleteCarById(RenoId);
          System.out.println(result);

    }

   private static void createTriggerNds(Car car) throws SQLException, ClassNotFoundException {   // Прибавляет к стоимости ндс.
        String nds;
        try{
            if (parseInt(car.getPrice()) < 0 || (parseInt(car.getPrice())==0)){
                System.out.println("Price must be more than zero.");
                System.exit(1);
            }
            nds = Integer.toString(parseInt(car.getPrice()) / 100 * 20 + parseInt(car.getPrice()));

        Connection conn = CarDataSource.getConnection();
        conn.createStatement().executeUpdate(
                " CREATE DEFINER  =`root`@`localhost`  TRIGGER `car_BEFORE_INSERT` BEFORE INSERT ON `car` FOR EACH ROW BEGIN\n" +
                        "set new.price = '"+nds+"';\n" +
                        "END");
       String car3 = new CarDaoImpl().saveNewCar(car);
       conn.createStatement().executeUpdate(
               "DROP TRIGGER `task1-2`.CAR_BEFORE_INSERT;");

   } catch (NumberFormatException e) {
        System.out.println("Invalid argument: argument price must be Integer");
        System.exit(1);
    }
            }
}


