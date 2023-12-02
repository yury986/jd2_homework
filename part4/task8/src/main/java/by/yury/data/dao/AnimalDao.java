package by.yury.data.dao;

import by.yury.data.pojo.singleTable.Animal;



public interface AnimalDao {

    String saveNewAnimal (Animal animal);

    Animal getAnimalById (String Id);
}
