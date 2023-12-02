package by.yury.data.pojo.tablePerClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "SHIP")
public class Ship extends Vehicle{

    @Column
    private String displacement;

    public Ship(String id, String speed, String displacement) {
        super(id, speed);
        this.displacement = displacement;
    }

    public Ship () {
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ship ship = (Ship) o;
        return Objects.equals(displacement, ship.displacement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), displacement);
    }
}
