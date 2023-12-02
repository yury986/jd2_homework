package by.yury.data.dao;

import by.yury.data.pojo.tablePerClass.Vehicle;

public interface VehicleDao {

    String saveNewVehicle (Vehicle vehicle);

    Vehicle getVehicleById (String Id);

}
