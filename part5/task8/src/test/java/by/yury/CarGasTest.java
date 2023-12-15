package by.yury;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

public class CarGasTest {

    @Test
    public void EngineTest() {
        ApplicationContext javaConfigContext =
                new AnnotationConfigApplicationContext(Config.class);
        CarGas carWithConstructor =
                javaConfigContext.getBean(CarGas.class);
        assertNotNull(carWithConstructor.getEngine());

    }
}
