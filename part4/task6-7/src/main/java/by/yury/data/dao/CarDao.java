package by.yury.data.dao;

import by.yury.data.pojo.Car;

import java.util.List;

public interface CarDao {

    String saveNewCar(Car car);

    Car getCarById(String id);

    boolean deleteCarById(String id);

    List<Car> readAll();
}
