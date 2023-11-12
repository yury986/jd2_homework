package by.tomko.data.Dao;

import by.tomko.data.pojo.Car;

import java.util.List;

public interface CarDao {

    public void refreshCar(String id, String name);

    Car getCarById(String id);

    Car loadCarById(String id);

    String saveNewCar(Car car);

    boolean deleteCarById(String id);

    Car findCarById(String id);


    List<Car> readAll();



}
