package by.yury;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

public class AnimalRepositoryTest {

    @Test
    public void AnimalRepository() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        AnimalService animalService =
                context.getBean(AnimalService.class);
        assertNotNull(animalService.getAnimalRepository());

    }

}
