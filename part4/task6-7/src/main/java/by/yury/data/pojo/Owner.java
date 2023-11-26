package by.yury.data.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "OWNER")

public class Owner {

    @Id
    @GenericGenerator(name = "car-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "car-uuid")
    @Column(name = "OWNER_ID")
    private String Id;

    @Column (name = "FIRST_NAME")
    private String firstName;

    @Column (name = "LAST_NAME")
    private String lastName;

    @Column (name = "DATE_BIRTHDAY")
    private String dateBirthday;

    @Embedded
    private Address address;

    public Owner() {
    }

    public Owner(String id, String firstName, String lastName, String dateBirthday,Address address) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirthday = dateBirthday;
        this.address = address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(Id, owner.Id) && Objects.equals(firstName, owner.firstName) && Objects.equals(lastName, owner.lastName) && Objects.equals(dateBirthday, owner.dateBirthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, dateBirthday);
    }
}
