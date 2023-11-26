package by.yury.data.dao;

import by.yury.data.TestSessionFactory;
import by.yury.data.ShowroomTestDataSource;
import by.yury.data.pojo.Car;
import by.yury.data.pojo.TechnicalCertificate;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.Assert.*;

public class CarDaoImplTest {

    CarDao carDao;

    Connection conn;

    @Before
    public void setUp() throws Exception {
        carDao = new CarDaoImpl(TestSessionFactory.getSessionFactory());
        conn = ShowroomTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM CAR");
    }

    @After
    public void tearDown() throws Exception {
        carDao = null;
        conn.createStatement().executeUpdate("DELETE FROM CAR");
        conn.close();
    }

    @Test
    public void testSaveNewCar() throws Exception {
        // Given
        Car car = new Car(null, "BMW", "Blue", "15000",
                new TechnicalCertificate("454", "MMA", "2005", "8489 MH-7"));


        // When
        String savedId = carDao.saveNewCar(car);

        // Then
        assertNotNull(savedId);
        Connection conn = ShowroomTestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from CAR where MODEL='BMW' and COLOR ='BLUE' and PRICE = '15000' and" +
                        " number = '454' and series = 'MMA' and year = '2005' and regPlate = '8489 MH-7'");
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testGetCarById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = ShowroomTestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `task6-7_test`.`car`\n" +
                "(`CAR_ID`,\n" +
                "`MODEL`,\n" +
                "`COLOR`,\n" +
                "`PRICE`,\n" +
                "`NUMBER`,\n" +
                "`SERIES`,\n" +
                "`YEAR`,\n" +
                "`REGPLATE`)\n" +
                "VALUES\n" +
                "('"+testId+"',\n" +
                "'Reno',\n" +
                "'White',\n" +
                "'10000',\n" +
                "'568',\n" +
                "'MMA',\n" +
                "'2006',\n" +
                "'8754 BC-4');\n");
        conn.close();

        //When
        Car car = carDao.getCarById(testId);

        //Then
        assertNotNull(car);
        assertEquals(testId, car.getId());
        assertEquals("Reno", car.getModel());
        assertEquals("White", car.getColor());
        assertEquals("10000", car.getPrice());
    }

    public void testDeleteCarById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = ShowroomTestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `task6-7_test`.`car`\n" +
                "(`CAR_ID`,\n" +
                "`MODEL`,\n" +
                "`COLOR`,\n" +
                "`PRICE`,\n" +
                "`NUMBER`,\n" +
                "`SERIES`,\n" +
                "`YEAR`,\n" +
                "`REGPLATE`)\n" +
                "VALUES\n" +
                "('"+testId+"',\n" +
                "'Reno',\n" +
                "'White',\n" +
                "'10000',\n" +
                "'568',\n" +
                "'MMA',\n" +
                "'2006',\n" +
                "'8754 BC-4');\n");

        //When
        boolean result = carDao.deleteCarById(testId);

        //Then
        assertTrue(result);
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from CAR where CAR_ID='" + testId + "';"
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







