package by.yury;

import org.springframework.stereotype.Component;

@Component
public class AnimalRepository2 implements IAnimalRepository {

    @Override
    public void save() {
        System.out.println("AnimalRepository 2 save");
    }
}
