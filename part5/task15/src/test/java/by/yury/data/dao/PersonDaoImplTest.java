package by.yury.data.dao;

import by.yury.data.TestDataConfiguration;
import by.yury.data.TestDataSource;
import by.yury.data.dao.PersonDao;
import by.yury.data.pojo.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfiguration.class)
@TestPropertySource(value = "classpath:test.liquibase.properties")
public class PersonDaoImplTest {

    @Autowired
    PersonDao personDao;

    @Before
    public void setUp() throws Exception {
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON;");

    }

    @After
    public void tearDown() throws Exception {
        personDao = null;
        Connection conn = TestDataSource.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM T_PERSON;");
    }

    @Test
    public void testSaveNewPerson() throws Exception {
        // Given
        Person person = new Person(
                null, "John", "Smith", "Minsk,Krasnaya str., 22-3",
                "KB789632", "+375339075645");


        // When
        String savedId = personDao.saveNewPerson(person);

        // Then
        assertNotNull(savedId);
        Connection conn = TestDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery(
                "select count(*) from T_PERSON where FIRST_NAME='John' and LAST_NAME='Smith'"
        );
        rs.next();
        int actualCount = rs.getInt(1);
        assertEquals(1, actualCount);
    }
}

