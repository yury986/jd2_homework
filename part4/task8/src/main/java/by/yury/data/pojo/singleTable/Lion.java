package by.yury.data.pojo.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "LION")
@DiscriminatorValue("L")

public class Lion extends Animal {

    private String speed;

    public Lion(String id, String typeOfAnimal, String classOfAnimal, String speed) {
        super(id, typeOfAnimal, classOfAnimal);
        this.speed = speed;
    }

    public Lion (){
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lion lion = (Lion) o;
        return Objects.equals(speed, lion.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speed);
    }
}
