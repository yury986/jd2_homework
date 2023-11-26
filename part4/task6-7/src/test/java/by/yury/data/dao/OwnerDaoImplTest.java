package by.yury.data.dao;

import by.yury.data.ShowroomTestDataSource;
import by.yury.data.TestSessionFactory;
import by.yury.data.pojo.Address;
import by.yury.data.pojo.Car;
import by.yury.data.pojo.Owner;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.Assert.*;

public class OwnerDaoImplTest {

    OwnerDao ownerDao;

    Connection conn;

    @Before
    public void setUp() throws Exception {
        ownerDao = new OwnerDaoImpl(TestSessionFactory.getSessionFactory());
        conn = ShowroomTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM OWNER");
    }

    @After
    public void tearDown() throws Exception {
        ownerDao = null;
        conn.createStatement().executeUpdate("DELETE FROM OWNER");
        conn.close();
    }

    @Test
    public void testSaveNewOwner() throws Exception {
        // Given
        Owner owner = new Owner(null, "Sergey", "Ivanov", "22.08.2014",
                new Address("Pushkina", "Minsk", "200_008"));


        // When
        String savedId = ownerDao.saveNewOwner(owner);

        // Then
        assertNotNull(savedId);
        Connection conn = ShowroomTestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from OWNER where FIRST_NAME='SERGEY' and LAST_NAME ='IVANOV' and DATE_BIRTHDAY = '22.08.2014'" +
                        " and STREET = 'Pushkina' and CITY = 'MINSK' and POSTALCODE = '200_008'");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testGetOwnerById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = ShowroomTestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `task6-7_test`.`owner`\n" +
                "(`OWNER_ID`,\n" +
                "`FIRST_NAME`,\n" +
                "`LAST_NAME`,\n" +
                "`DATE_BIRTHDAY`,\n" +
                "`STREET`,\n" +
                "`CITY`,\n" +
                "`POSTALCODE`)\n" +
                "VALUES\n" +
                "('"+testId+"',\n" +
                "'YURY',\n" +
                "'PETROV',\n" +
                "'22.08.2010',\n" +
                "'pr.NEZAVISIMOSTY',\n" +
                "'Minsk',\n" +
                "'200_002');\n");
        conn.close();

        //When
        Owner owner = ownerDao.getOwnerById(testId);

        //Then
        assertNotNull(owner);
        assertEquals(testId, owner.getId());
        assertEquals("YURY", owner.getFirstName());
        assertEquals("PETROV", owner.getLastName());
        assertEquals("22.08.2010", owner.getDateBirthday());
    }


    public void testDeleteOwnerById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = ShowroomTestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `task6-7_test`.`owner`\n" +
                "(`OWNER_ID`,\n" +
                "`FIRST_NAME`,\n" +
                "`LAST_NAME`,\n" +
                "`DATE_BIRTHDAY`,\n" +
                "`STREET`,\n" +
                "`CITY`,\n" +
                "`POSTALCODE`)\n" +
                "VALUES\n" +
                "('"+testId+"',\n" +
                "'YURY',\n" +
                "'PETROV',\n" +
                "'22.08.2010',\n" +
                "'pr.NEZAVISIMOSTY',\n" +
                "'Minsk',\n" +
                "'200_002');\n");

        //When
        boolean result = ownerDao.deleteOwnerById(testId);

        //Then
        assertTrue(result);
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from OWNER where OWNER_ID='" + testId + "';"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(0, actualCount);
        conn.close();
    }

    @Test
    @Ignore("Not implemented")
    public void readAll() {
        assertTrue(true);
    }



}
