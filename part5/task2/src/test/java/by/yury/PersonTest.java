package by.yury;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

public class PersonTest {

    private ConfigurableApplicationContext context;
    @Before
    public void init() {
         context = new ClassPathXmlApplicationContext("spring.cfg.xml");
    }

    @Test

    public void ObjectExist() {

        assertTrue( context.getBean("person",Person.class) instanceof Person);

    }

}
