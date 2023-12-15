package by.yury;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
    public class AnimalService {
        private IAnimalRepository animalRepository;

        @Autowired
        public AnimalService(@Qualifier("animalRepository1") IAnimalRepository animalRepository){
            this.animalRepository=animalRepository;
        }

    public IAnimalRepository getAnimalRepository() {
        return animalRepository;
    }

    public void setAnimalRepository(IAnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void save(){
            animalRepository.save();


        }
    }


