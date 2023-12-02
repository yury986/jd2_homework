package by.yury.data.dao;

import by.yury.data.InheritanceTestDataSource;
import by.yury.data.InheritanceTestSessionFactory;
import by.yury.data.pojo.joined.Person;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


import static org.junit.Assert.*;

public class PersonDaoImplTest {

    PersonDao personDao;

    @org.junit.Before
    public void setUp() throws Exception {
        personDao = new PersonDaoImpl(InheritanceTestSessionFactory.getSessionFactory());
        Connection conn = InheritanceTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM PERSON;");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        personDao = null;
        Connection conn = InheritanceTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM PERSON;");

    }

    @Test
    public void testSaveNewPerson() throws Exception {
        // Given
        Person person = new Person(null, "John", "Smith");

        // When
        String savedId = personDao.saveNewPerson(person);


        // Then
        assertNotNull(savedId);
        Connection conn = InheritanceTestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from PERSON where NAME='John' and SURNAME='Smith'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testGetPersonById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = InheritanceTestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `task8_test`.`person`\n" +
                "(`PERSON_ID`,\n" +
                "`NAME`,\n" +
                "`SURNAME`)\n" +
                "VALUES\n" +
                "('" + testId + "',\n" +
                "'Mike',\n" +
                "'Serov');\n");
        conn.close();

        //When
        Person person = personDao.getPersonById(testId);

        //Then
        assertNotNull(person);
        assertEquals(testId, person.getId());
        assertEquals("Mike", person.getName());
        assertEquals("Serov", person.getSurname());
    }

}

