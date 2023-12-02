package by.yury.data.pojo.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE")
@PrimaryKeyJoinColumn(name = "EMPLOYEE_ID")

public class Employee extends Person {

    @Column
    private String company;

    @Column
    private String salary;

    public Employee(String id, String name, String surname, String company, String salary) {
        super(id, name, surname);
        this.company = company;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, salary);
    }
}
