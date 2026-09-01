import java.util.ArrayList;
import java.util.List;

/*
 * Author: Blizzard Edge
 * Class: Handler
 * Purpose: Represents a staff member responsible for one animal family.
 * Last Revision Date: September 1, 2026
 */

public class Handler extends Staff {

    private final AnimalFamily family;

    /*
     * Creates a Handler assigned to an animal family.
     *
     * @param family animal family assigned to the Handler
     */
  
    public Handler(AnimalFamily family) {
        super(family + " Handler");
        this.family = family;
    }

    /*
     * Gets the Handler's assigned animal family.
     *
     * @return animal family
     */
  
    public AnimalFamily getFamily() {
        return family;
    }

    /*
     * DELEGATION EXAMPLE:
     *
     * The Handler does not implement animal sounds itself.
     * Instead, it delegates the action to each Animal object.
     *
     * This allows polymorphism to determine the appropriate
     * makeSound() implementation.
     *
     * @param animals animals to wake
     */
  
    public void wakeAnimals(List<Animal> animals) {

        System.out.println(
                getName() + " is waking animals."
        );

        for (Animal animal : new ArrayList<>(animals)) {
            animal.makeSound();
        }
    }

    /*
     * Feeds each animal.
     *
     * If an animal eats 0 or too much, it has a 50% chance
     * of becoming unhealthy.
     *
     * @param animals animals being fed
     * @return animals that became unhealthy
     */
  
    public List<Animal> feedAnimals(List<Animal> animals) {

        System.out.println(
                getName() + " is feeding animals."
        );

        List<Animal> newlySick = new ArrayList<>();

        for (Animal animal : new ArrayList<>(animals)) {

            int foodUnits = animal.eat();

            /*
             * If the animal eats 0 or too much, there is a
             * 50% chance of becoming unhealthy.
             */
          
            if ((foodUnits == 0 || foodUnits > 1)
                    && Math.random() < 0.50) {

                animal.setHealthy(false);

                newlySick.add(animal);

                System.out.println(
                        animal.getName()
                        + " has become unhealthy and is moving to the Hospital."
                );
            }
        }

        return newlySick;
    }

    /*
     * DELEGATION EXAMPLE:
     *
     * The Handler delegates roaming behavior to the Animal.
     * The actual implementation depends on the animal's family.
     *
     * @param animals animals being exercised
     */
  
    public void exerciseAnimals(List<Animal> animals) {

        System.out.println(
                getName() + " is exercising animals."
        );

        for (Animal animal : new ArrayList<>(animals)) {
            animal.roam();
        }
    }

    /*
     * Beds animals down for the evening.
     *
     * @param animals animals being put to bed
     */
  
    public void bedAnimals(List<Animal> animals) {

        System.out.println(
                getName() + " is bedding down animals."
        );

        for (Animal animal : new ArrayList<>(animals)) {
            animal.sleep();
        }
    }
}
