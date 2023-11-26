package by.yury.data.dao;

import by.yury.data.pojo.Car;
import by.yury.data.pojo.Owner;

import java.util.List;

public interface OwnerDao {

    String saveNewOwner(Owner owner);

    Owner getOwnerById(String id);

    boolean deleteOwnerById(String id);

    List<Owner> readAll();

}
