package by.yury.data.pojo.tablePerClass;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PLANE")

public class Plane extends Vehicle{

    @Column
    private String lift;

    public Plane(String id, String speed, String lift) {
        super(id, speed);
        this.lift = lift;
    }

    public Plane(){
    }

    public String getLift() {
        return lift;
    }

    public void setLift(String lift) {
        this.lift = lift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(lift, plane.lift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lift);
    }
}
