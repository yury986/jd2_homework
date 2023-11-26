package by.yury.data.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAR")

public class Car {

    @Id
    @GenericGenerator(name = "car-uuid", strategy = "uuid")
    @GeneratedValue(generator = "car-uuid")
    @Column(name = "CAR_ID")
    private String id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "PRICE")
    private String price;

    @Embedded
    TechnicalCertificate technicalCertificate;

    public Car(){
    }

    public Car(String id, String model, String color, String price, TechnicalCertificate technicalCertificate) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.price = price;
        this.technicalCertificate = technicalCertificate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, color, price);
    }
}

