package by.tomko.data.dao;

import by.tomko.CarDataSource;

import by.tomko.data.Dao.CarDao;
import by.tomko.data.Dao.CarDaoImpl;
import by.tomko.data.pojo.Car;
import org.junit.Test;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.Assert.*;

public class CarDaoTest {

    CarDao carDao;


    @org.junit.Before
    public void setUp() throws Exception {
        carDao = new CarDaoImpl();
        Connection conn = CarDataSource.getConnection();
        conn.createStatement().executeUpdate(
                "truncate table CAR;"
        );
    }

    @org.junit.After
    public void tearDown() throws Exception {
        carDao = null;
        Connection conn = CarDataSource.getConnection();
        conn.createStatement().executeUpdate(
                "truncate table CAR;"
        );
    }

    @org.junit.Test
    public void testSaveNewCar() throws Exception {
        // Given
        Car car = new Car("1", "BMW", "Black", "20000"
        );

        // When
        String savedId = carDao.saveNewCar(car);

        // Then
        assertNotNull(savedId);
        Connection conn = CarDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from CAR where  MODEL ='BMW' and COLOR = 'Black'and PRICE = '20000'"
        );

        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    public void testDeleteCarById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = CarDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `task1-2`.`car`\n" +
                "(`CAR_ID`,\n" +
                "`MODEL`,\n" +
                "`COLOR`,\n" +
                "`PRICE`)\n" +
                "VALUES\n" +
                "('"+testId+"',\n" +
                "'Reno',\n" +
                "'White',\n" +
                "'10000');\n");

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
    public void testReadCarById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = CarDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `task1-2`.`car`\n" +
                "(`CAR_ID`,\n" +
                "`MODEL`,\n" +
                "`COLOR`,\n" +
                "`PRICE`)\n" +
                "VALUES\n" +
                "('"+testId+"',\n" +
                "'Reno',\n" +
                "'White',\n" +
                "'10000');\n");
        conn.close();

        //When
        Car car = carDao.findCarById(testId);

        //Then
        assertNotNull(car);
        assertEquals(testId, car.getId());
        assertEquals("Reno", car.getModel());
        assertEquals("White", car.getColor());
        assertEquals("10000", car.getPrice());

    }

    @org.junit.Test
    public void readAll() {
    }
}
