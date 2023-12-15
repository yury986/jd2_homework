package by.yury;


import org.springframework.stereotype.Component;

@Component
public class AnimalRepository1 implements IAnimalRepository {


    @Override
    public void save() {
        System.out.println("AnimalRepository 1 save");
    }
}
