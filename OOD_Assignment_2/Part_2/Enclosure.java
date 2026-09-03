import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Author: Caitlin Hagler
 * Class: Enclosure
 * Purpose: Stores animals belonging to one concrete animal type.
 * Last Revision Date: September 2, 2026
 */

public class Enclosure {
    private final String name;
    private final String animalType;
    private final List<Animal> animals;
    /*
     * Creates an enclosure for one animal type.
     *
     * @param animalType type of animal kept in this enclosure
     */
    public Enclosure(String animalType) {
        this.name = animalType + " Enclosure";
        this.animalType = animalType;
        this.animals = new ArrayList<>();
    }
    /*
     * Adds an animal to this enclosure.
     *
     * @param animal animal to add
     */  
    public void addAnimal(Animal animal) {
        if (!animal.getTypeName().equals(animalType)) {
            throw new IllegalArgumentException(
                    "Wrong animal type for enclosure."
            );
        }
        animals.add(animal);
    }
    /*
     * Removes an animal from the enclosure.
     *
     * @param animal animal to remove
     */  
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
    /*
     * Returns the animals in the enclosure.
     *
     * @return unmodifiable list of animals
     */  
    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }
    /*
     * Gets the enclosure name.
     *
     * @return enclosure name
     */  
    public String getName() {
        return name;
    }
    /*
     * Gets the animal type assigned to the enclosure.
     *
     * @return animal type
     */  
    public String getAnimalType() {
        return animalType;
    }
}