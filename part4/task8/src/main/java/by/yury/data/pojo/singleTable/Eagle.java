package by.yury.data.pojo.singleTable;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "EAGLE")
@DiscriminatorValue("E")
public class Eagle extends Animal{

    private String flightAltitude;

    public Eagle(String id, String typeOfAnimal, String classOfAnimal, String flightAltitude) {
        super(id, typeOfAnimal, classOfAnimal);
        this.flightAltitude = flightAltitude;
    }

    public Eagle() {
    }

    public String getFlightAltitude() {
        return flightAltitude;
    }

    public void setFlightAltitude(String flightAltitude) {
        this.flightAltitude = flightAltitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Eagle eagle = (Eagle) o;
        return Objects.equals(flightAltitude, eagle.flightAltitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flightAltitude);
    }
}
