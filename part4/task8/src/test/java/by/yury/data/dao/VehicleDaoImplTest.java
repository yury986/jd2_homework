package by.yury.data.dao;

import by.yury.data.InheritanceTestDataSource;
import by.yury.data.InheritanceTestSessionFactory;
import by.yury.data.pojo.tablePerClass.Vehicle;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VehicleDaoImplTest {

    VehicleDao vehicleDao;

    @org.junit.Before
    public void setUp() throws Exception {
        vehicleDao = new VehicleDaoImpl(InheritanceTestSessionFactory.getSessionFactory());
        Connection conn = InheritanceTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM VEHICLE;");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        vehicleDao = null;
        Connection conn = InheritanceTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM VEHICLE;");

    }

    @Test
    public void testSaveNewVehicle() throws Exception {
        // Given
        Vehicle vehicle = new Vehicle(null, "20");

        // When
        String savedId = vehicleDao.saveNewVehicle(vehicle);


        // Then
        assertNotNull(savedId);
        Connection conn = InheritanceTestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from VEHICLE where SPEED ='20'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testGetVehicleById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = InheritanceTestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `task8_test`.`Vehicle`\n" +
                "(`VEHICLE_ID`,\n" +
                "`SPEED`)\n" +
                "VALUES\n" +
                "('" + testId + "',\n" +
                "'48');\n");
        conn.close();

        //When
        Vehicle vehicle = vehicleDao.getVehicleById(testId);

        //Then
        assertNotNull(vehicle);
        assertEquals(testId, vehicle.getId());
        assertEquals("48", vehicle.getSpeed());
    }
}
