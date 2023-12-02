package by.yury.data.pojo.tablePerClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Vehicle {
    @Id
    @GenericGenerator(strategy = "uuid", name = "vehicle_uuid")
    @GeneratedValue(generator = "vehicle_uuid")
    @Column(name = "VEHICLE_ID")
    private String id;

    @Column
    private String speed;

    public Vehicle(String id, String speed) {
        this.id = id;
        this.speed = speed;
    }

    public Vehicle() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(speed, vehicle.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speed);
    }
}
