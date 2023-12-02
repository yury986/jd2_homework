package by.yury.data.dao;

import by.yury.data.InheritanceTestDataSource;
import by.yury.data.InheritanceTestSessionFactory;
import by.yury.data.pojo.singleTable.Animal;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AnimalDaoImplTest {

    AnimalDao animalDao;

    @org.junit.Before
    public void setUp() throws Exception {
        animalDao = new AnimalDaoImpl(InheritanceTestSessionFactory.getSessionFactory());
        Connection conn = InheritanceTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM ANIMAL;");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        animalDao = null;
        Connection conn = InheritanceTestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM ANIMAL;");

    }

    @Test
    public void testSaveNewAnimal() throws Exception {
        // Given
        Animal animal = new Animal(null, "Chordates", "Reptiles");

        // When
        String savedId = animalDao.saveNewAnimal(animal);


        // Then
        assertNotNull(savedId);
        Connection conn = InheritanceTestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from ANIMAL where TYPEOFANIMAL='Chordates' and CLASSOFANIMAL='Reptiles'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }

    @Test
    public void testGetById() throws SQLException, ClassNotFoundException {
        // Given
        String testId = UUID.randomUUID().toString();
        Connection conn = InheritanceTestDataSource.getConnection();
        conn.createStatement().executeUpdate("INSERT INTO `task8_test`.`animal`\n" +
                "(`ANIMAL_TYPE`,\n" +
                "`ANIMAL_ID`,\n" +
                "`TYPEOFANIMAL`,\n" +
                "`CLASSOFANIMAL`)\n" +
                "VALUES\n" +
                "('P',\n" +
                "'"+ testId +"',\n" +
                "'Chordates',\n" +
                "'Mammals');\n");
        conn.close();

        //When
        Animal animal = animalDao.getAnimalById(testId);

        //Then
        assertNotNull(animal);

        assertEquals(testId, animal.getId());
        assertEquals("Chordates", animal.getTypeOfAnimal());
        assertEquals("Mammals", animal.getClassOfAnimal());
    }


}
