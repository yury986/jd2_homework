package by.tomko.data.Dao;

import by.tomko.data.pojo.Car;

import java.util.List;

public interface CarDao {

    Car refreshCar(String id, Car car);

    Car getCarById(String id);

    Car loadCarById(String id);

    String saveNewCar(Car car);

    boolean deleteCarById(String id);

    Car findCarById(String id);


    List<Car> readAll();



}
