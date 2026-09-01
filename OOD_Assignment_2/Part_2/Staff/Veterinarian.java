import java.util.ArrayList;
import java.util.List;

/*
 * Author: Caitlin Hagler
 * Class: Veterinarian
 * Purpose: Treats unhealthy animals in the Zoo Hospital.
 * Last Revision Date: September 1, 2026
 */

public class Veterinarian extends Staff {

    /*
     * Creates a Veterinarian.
     */
  
    public Veterinarian() {
        super("Veterinarian");
    }

    /*
     * Treats every animal currently in the Hospital once.
     *
     * Each animal has a 50% chance of becoming healthy.
     *
     * @param hospital Zoo hospital containing sick animals
     * @return animals that recovered
     */
  
    public List<Animal> treatAnimals(Hospital hospital) {

        System.out.println(
                getName() + " is treating sick animals."
        );

        List<Animal> recovered = new ArrayList<>();

        /*
         * Create a copy so the Hospital can safely be modified
         * after treatment without changing the list being iterated.
         */
      
        for (Animal animal :
                new ArrayList<>(hospital.getAnimals())) {

            if (Math.random() < 0.50) {

                animal.setHealthy(true);
                recovered.add(animal);

                System.out.println(
                        animal.getName()
                        + " is feeling better and is moving back to its enclosure."
                );
            }
            else {

                System.out.println(
                        animal.getName()
                        + " is still unhealthy."
                );
            }
        }

        return recovered;
    }
}
