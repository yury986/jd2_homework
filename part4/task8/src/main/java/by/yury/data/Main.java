package by.yury.data;


import by.yury.data.dao.ObjectDaoImpl;
import by.yury.data.pojo.joined.Employee;
import by.yury.data.pojo.joined.Person;
import by.yury.data.pojo.joined.Student;
import by.yury.data.pojo.singleTable.Animal;
import by.yury.data.pojo.singleTable.Eagle;
import by.yury.data.pojo.singleTable.Lion;
import by.yury.data.pojo.tablePerClass.Plane;
import by.yury.data.pojo.tablePerClass.Ship;
import by.yury.data.pojo.tablePerClass.Vehicle;


public class Main {

    public static void main(String[] args) {

        Person person = new Person(null, "Pit", "Vasiliev");
        Employee employee = new Employee(null,"Nick", "Vetrov", "BMZ", "2000");
        Student student = new Student(null, "Georg", "Mcfly", "FITR", "5");

        Animal animal = new Animal(null, "Chordates", "Reptiles");
        Eagle eagle = new Eagle(null, "Feathered", "Eagle", "3000");
        Lion lion = new Lion(null, "Predators", "Feline", "20");

        Vehicle vehicle = new Vehicle(null, "20");
        Ship ship = new Ship(null, "30","10000");
        Plane plane = new Plane(null, "300", "50000");

        ObjectDaoImpl objectDaoImpl = new ObjectDaoImpl(InheritanceSessionFactory.getSessionFactory());
        objectDaoImpl.saveNewObject(person);
        objectDaoImpl.saveNewObject(employee);
        objectDaoImpl.saveNewObject(student);

        objectDaoImpl.saveNewObject(animal);
        objectDaoImpl.saveNewObject(lion);
        objectDaoImpl.saveNewObject(eagle);

        objectDaoImpl.saveNewObject(vehicle);
        objectDaoImpl.saveNewObject(ship);
        objectDaoImpl.saveNewObject(plane);



    }
}

