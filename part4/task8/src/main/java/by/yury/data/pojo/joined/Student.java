package by.yury.data.pojo.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Objects;


@Entity
    @Table(name = "STUDENT")
    @PrimaryKeyJoinColumn(name = "PERSON_ID")

    public class Student extends Person{

        @Column
        private  String faculty;

        @Column
        private  String mark;

        public Student(String id, String name, String surname, String faculty, String mark) {
            super(id, name, surname);
            this.faculty = faculty;
            this.mark = mark;
        }

       public Student () {
       }

        public String getFaculty() {
            return faculty;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return mark == student.mark && Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty, mark);
    }
}
