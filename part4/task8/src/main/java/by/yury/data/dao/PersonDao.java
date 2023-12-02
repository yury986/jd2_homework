package by.yury.data.dao;

import by.yury.data.pojo.joined.Person;


public interface PersonDao {

    String saveNewPerson (Person person);

    Person getPersonById (String Id);


}
