package by.yury.data.dao;

import by.yury.data.pojo.joined.Person;
import by.yury.data.pojo.singleTable.Animal;

public interface ObjectDao {

    String saveNewObject (Object object);

    Object getObjectById (Object object);

}
