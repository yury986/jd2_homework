package by.yury.data.pojo.singleTable;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ANIMAL")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "ANIMAL_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")

public class Animal {

    @Id
    @GenericGenerator(strategy = "uuid", name = "animal_uuid")
    @GeneratedValue(generator = "animal_uuid")
    @Column(name = "ANIMAL_ID")
    private String id;

    @Column
    private String typeOfAnimal;

    @Column
    private String classOfAnimal;

    public Animal(String id, String typeOfAnimal, String classOfAnimal) {
        this.id = id;
        this.typeOfAnimal = typeOfAnimal;
        this.classOfAnimal = classOfAnimal;
    }

    public Animal() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    public String getClassOfAnimal() {
        return classOfAnimal;
    }

    public void setClassOfAnimal(String classOfAnimal) {
        this.classOfAnimal = classOfAnimal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) && Objects.equals(typeOfAnimal, animal.typeOfAnimal) && Objects.equals(classOfAnimal, animal.classOfAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeOfAnimal, classOfAnimal);
    }
}
