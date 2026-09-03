import java.util.ArrayList;
import java.util.List;

/*
 * Author: Caitlin Hagler
 * Class: Zoo
 * Purpose: Creates, manages, and runs the Zoo simulation.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Zoo {
    /*
     * AGGREGATION/COMPOSITION EXAMPLE:
     *
     * The Zoo contains and manages its Enclosures, Hospital,
     * Handlers, and Veterinarian.
     */ 
    private final List<Enclosure> enclosures;
    private final Hospital hospital;
    private final List<Handler> handlers;
    private final Veterinarian veterinarian;
    // Creates an empty Zoo and its Hospital and Veterinarian.
    public Zoo() {
        enclosures = new ArrayList<>();
        hospital = new Hospital();
        handlers = new ArrayList<>();
        veterinarian = new Veterinarian();
    }
    /*
     * Initializes the Zoo.
     * Creates:
     * - 12 Enclosures
     * - 1 Hospital
     * - 4 Handlers
     * - 1 Veterinarian
     * - 36 Animals
     * Three animals of each concrete type are created.
     */
    public void initialize() {
        String[] types = {
                "Rhino",
                "Elephant",
                "Hippo",
                "Tiger",
                "Lion",
                "Cheetah",
                "Parrot",
                "Falcon",
                "Owl",
                "Dog",
                "Wolf",
                "Fox"
        };
        // Create one enclosure for every animal type.
        for (String type : types) {
            enclosures.add(new Enclosure(type));
        }
        // Create one Handler for each animal family.
        handlers.add(
                new Handler(AnimalFamily.Pachyderm)
        );
        handlers.add(
                new Handler(AnimalFamily.Feline)
        );
        handlers.add(
                new Handler(AnimalFamily.Bird)
        );
        handlers.add(
                new Handler(AnimalFamily.Canine)
        );
        /*
         * Three unique instances of every concrete Animal Type.
         *
         * 12 animal types × 3 = 36 animals.
         */
        for (Enclosure enclosure : enclosures) {
            for (int i = 0; i < 3; i++) {
                Animal animal =
                        createAnimal(enclosure.getAnimalType());
                enclosure.addAnimal(animal);
            }
        }
    }
    /*
     * POLYMORPHISM EXAMPLE:
     * This method returns an Animal reference while creating
     * different concrete Animal subclasses.
     * 
     * Later, calls such as animal.makeSound() and animal.roam()
     * automatically use the correct subclass implementation.
     * 
     * @param type animal type to create
     * @return newly created Animal
     */
    private Animal createAnimal(String type) {
        switch (type) {
            case "Rhino":
                return new Rhino();

            case "Elephant":
                return new Elephant();

            case "Hippo":
                return new Hippo();

            case "Tiger":
                return new Tiger();

            case "Lion":
                return new Lion();

            case "Cheetah":
                return new Cheetah();

            case "Parrot":
                return new Parrot();

            case "Falcon":
                return new Falcon();

            case "Owl":
                return new Owl();

            case "Dog":
                return new Dog();

            case "Wolf":
                return new Wolf();

            case "Fox":
                return new Fox();

            default:
                throw new IllegalArgumentException(
                        "Unknown animal type: " + type
                );
        }
    }
    // Runs the complete Zoo simulation for 30 days.
        public void runSimulation() {
        initialize();
        for (int day = 1; day <= 30; day++) {
            System.out.println();
            System.out.println("========================================");
            System.out.println("             START DAY " + day);
            System.out.println("========================================");

            wakeAnimals();

            feedAnimals();

            zooStatus();

            exerciseAnimals();

            treatAnimals();

            bedAnimals();

            System.out.println("========================================");
            System.out.println("             END DAY " + day);
            System.out.println("========================================");
            System.out.println();
        }
    }
    // Each Handler wakes the animals in its assigned family.
    private void wakeAnimals() {
        for (Handler handler : handlers) {
            handler.wakeAnimals(
                    getAnimalsForFamily(handler.getFamily())
            );
        }
    }
    /*
     * Each Handler feeds its assigned animals.
     *
     * Animals that become unhealthy are moved to the Hospital.
     */
    private void feedAnimals() {
        for (Handler handler : handlers) {
            List<Animal> sickAnimals =
                    handler.feedAnimals(
                            getAnimalsForFamily(
                                    handler.getFamily()
                            )
                    );
            for (Animal animal : sickAnimals) {
                moveToHospital(animal);
            }
        }
    }
    /*
     * Displays the current Zoo status.
     *
     * Each enclosure lists its animals and assigned Handler.
     * The Hospital lists its animals and Veterinarian.
     */
    public void zooStatus() {
        System.out.println();
        System.out.println(
                "---------------- ZOO STATUS ----------------"
        );
        for (Enclosure enclosure : enclosures) {
            Handler handler =
                    getHandlerForType(
                            enclosure.getAnimalType()
                    );

            System.out.printf(
                    "%-20s Handler: %-20s%n",
                    enclosure.getName(),
                    handler.getName()
            );
            for (Animal animal :
                    enclosure.getAnimals()) {
                System.out.printf(
                        "   %-20s Healthy: %s%n",
                        animal.getName(),
                        animal.isHealthy()
                );
            }
        }
        System.out.println(
                "Hospital              Veterinarian: "
                + veterinarian.getName()
        );
        for (Animal animal :
                hospital.getAnimals()) {
            System.out.printf(
                    "   %-20s Healthy: %s%n",
                    animal.getName(),
                    animal.isHealthy()
            );
        }
        System.out.println(
                "---------------------------------------------"
        );
    }
    // Each Handler exercises its assigned animals. 
    private void exerciseAnimals() {
        for (Handler handler : handlers) {
            handler.exerciseAnimals(
                    getAnimalsForFamily(
                            handler.getFamily()
                    )
            );
        }
    }
    /*
     * Veterinarian treats all sick animals.
     *
     * Animals that recover are moved back to their
     * normal enclosure.
     */  
    private void treatAnimals() {
        List<Animal> recovered =
                veterinarian.treatAnimals(hospital);
        for (Animal animal : recovered) {
            moveToEnclosure(animal);
        }
    }
    // Each Handler beds down its assigned animals. 
    private void bedAnimals() {
        for (Handler handler : handlers) {
            handler.bedAnimals(
                    getAnimalsForFamily(
                            handler.getFamily()
                    )
            );
        }
    }
    /*
     * Moves an unhealthy animal from its enclosure
     * to the Hospital.
     *
     * @param animal unhealthy animal
     */
    public void moveToHospital(Animal animal) {
        Enclosure enclosure =
                findEnclosure(
                        animal.getTypeName()
                );
        if (enclosure != null) {
            enclosure.removeAnimal(animal);
        }
        hospital.admitAnimal(animal);
    }
    /*
     * Moves a recovered animal from the Hospital back
     * to its normal enclosure.
     *
     * @param animal recovered animal
     */
    public void moveToEnclosure(Animal animal) {
        hospital.releaseAnimal(animal);

        Enclosure enclosure =
                findEnclosure(
                        animal.getTypeName()
                );
        if (enclosure != null) {
            enclosure.addAnimal(animal);
        }
    }
    /*
     * Finds the enclosure corresponding to an animal type.
     *
     * @param type animal type
     * @return matching enclosure or null if not found
     */  
    public Enclosure findEnclosure(String type) {
        for (Enclosure enclosure : enclosures) {
            if (enclosure.getAnimalType().equals(type)) {
                return enclosure;
            }
        }
        return null;
    }
    /*
     * Finds the Handler assigned to a particular animal type.
     *
     * @param type animal type
     * @return assigned Handler
     */  
    private Handler getHandlerForType(String type) {
        AnimalFamily family =
                getFamilyForType(type);
        for (Handler handler : handlers) {
            if (handler.getFamily() == family) {
                return handler;
            }
        }
        throw new IllegalStateException(
                "No Handler found for " + family
        );
    }
    /*
     * Determines the family associated with an animal type.
     *
     * @param type animal type
     * @return corresponding AnimalFamily
     */  
    private AnimalFamily getFamilyForType(String type) {
        switch (type) {
            case "Rhino":
            case "Elephant":
            case "Hippo":
                return AnimalFamily.Pachyderm;

            case "Tiger":
            case "Lion":
            case "Cheetah":
                return AnimalFamily.Feline;

            case "Parrot":
            case "Falcon":
            case "Owl":
                return AnimalFamily.Bird;

            case "Dog":
            case "Wolf":
            case "Fox":
                return AnimalFamily.Canine;

            default:
                throw new IllegalArgumentException(
                        "Unknown animal type: " + type
                );
        }
    }
    /*
     * Gets all currently enclosed animals belonging to a family.
     *
     * Animals in the Hospital are intentionally excluded because
     * sick animals are no longer assigned to their Handler's enclosure.
     *
     * @param family animal family
     * @return list of animals belonging to the family
     */  
    private List<Animal> getAnimalsForFamily(
            AnimalFamily family) {
        List<Animal> animals =
                new ArrayList<>();
        for (Enclosure enclosure : enclosures) {
            if (getFamilyForType(
                    enclosure.getAnimalType()
            ) == family) {
                animals.addAll(
                        enclosure.getAnimals()
                );
            }
        }
        return animals;
    }
}