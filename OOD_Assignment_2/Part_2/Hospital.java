import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Author: Caitlin Hagler
 * Class: Hospital
 * Purpose: Stores animals that are currently unhealthy.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Hospital {
    private final List<Animal> animals;
    /*
     * Creates an empty hospital.
     */  
    public Hospital() {
        animals = new ArrayList<>();
    }
    /*
     * Admits an unhealthy animal.
     *
     * @param animal animal being admitted
     */  
    public void admitAnimal(Animal animal) {
        animals.add(animal);
    }
    /*
     * Releases an animal after it has recovered.
     *
     * @param animal animal being released
     */  
    public void releaseAnimal(Animal animal) {
        animals.remove(animal);
    }
    /*
     * Gets all animals currently in the hospital.
     *
     * @return unmodifiable list of hospital animals
     */  
    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }
}