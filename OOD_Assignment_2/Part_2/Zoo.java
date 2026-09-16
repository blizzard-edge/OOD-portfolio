import java.util.ArrayList;
import java.util.List;

/*
 * Author: Caitlin Hagler
 * Class: Zoo
 * Purpose: Creates, manages, and runs the Zoo simulation.
 * IDE: BlueJ
 * Last Revision Date: September 16, 2026
 */

public class Zoo {
    /*
     * Aggregation Example:
     *
     * The Zoo contains and manages its Enclosures, Hospital,
     * Handlers, and Veterinarian.
     */ 
    private final List<Enclosure> enclosures;
    private final Hospital hospital;
    private final List<Handler> handlers;
    private final Veterinarian veterinarian;
    
    private final List<Shop> shops;
    private final List<Vendor> vendors;
    private final SalesTracker salesTracker;    
    /*
     * Creates an empty Zoo and obtains the Singleton Hospital 
     * and SalesTracker instances.
     */
    public Zoo() {
        enclosures = new ArrayList<>();
        
        // Singleton: Hospital uses eager instantiation.
        hospital = Hospital.getInstance();
        
        handlers = new ArrayList<>();
        veterinarian = new Veterinarian();
        
        shops = new ArrayList<>();
        vendors = new ArrayList<>();

        // Singleton: SalesTracker uses lazy instantiation.
        salesTracker = SalesTracker.getInstance();
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
         * 12 animal types x3 = 36 animals.
         */
        for (Enclosure enclosure : enclosures) {
            for (int i = 0; i < 3; i++) {
                Animal animal =
                        createAnimal(enclosure.getAnimalType());
                enclosure.addAnimal(animal);
            }
        }
        // Initialize the five Shops and their Vendors.
        initializeShops();
    }
    /*
     * Creates and initializes the five required Zoo Shops.
     *
     * Each Shop receives:
     * - 100-200 starting inventory
     * - $1-$10 item price
     * - 10%-25% sale likelihood
     * - one uniquely named Vendor
     *
     * All four SalesBehavior Strategies are used at least once.
     */
    private void initializeShops() {
        String[] shopNames = {
            "Gifts",
            "Maps",
            "Drinks",
            "Food",
            "Toys"
        };    
        SalesBehavior[] behaviors = {
            new NoSell(),
            new SoftSell(),
            new NormalSell(),
            new HardSell(),
            new NormalSell()
        };    
        for (int i = 0; i < shopNames.length; i++) {
            int inventory =
                    100 + (int) (Math.random() * 101);    
            double price =
                    1 + (Math.random() * 9);    
            double likelihood =
                    0.10 + (Math.random() * 0.15);
    
            Shop shop = new Shop(
                    shopNames[i],
                    inventory,
                    price,
                    likelihood
            );
    
            Vendor vendor =
                    new Vendor(shop, behaviors[i]);
   
            shop.setVendor(vendor);
    
            shops.add(shop);
            vendors.add(vendor);
    
            // Observer: SalesTracker subscribes to this Shop.
            salesTracker.registerShop(shop);
        }
    }
    /*
     * Each Vendor prepares their assigned Shop.
     *
     * If a Shop has fewer than 20 items, the Vendor causes
     * the Shop to purchase 100 additional items.
     */
    private void prepareShops() {
        for (Vendor vendor : vendors) {
            vendor.prepareShop();
        }
    } 
    /*
     * Simulates the visitors who shop at the Zoo Shops.
     *
     * Each day, between 50 and 100 visitors enter the Zoo.
     * Each visitor visits Shops until all Shops have been visited
     * or the visitor exits.
     *
     * Shop events are handled by the Observer pattern and are
     * not printed individually to the console.
     */
    private void sellItems() {
        int visitors =
                50 + (int) (Math.random() * 51);
        System.out.println(
                "Today we have " + visitors + " visitors!"
        );
        for (int visitor = 0; visitor < visitors; visitor++) {
            for (Shop shop : shops) {
                boolean exited = shop.visit();
                if (exited) {
                    break;
                }
            }
        }
    }
    /*
     * Polymorphism Example:
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

            prepareShops();
            
            wakeAnimals();

            feedAnimals();

            zooStatus();

            sellItems();
            
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
        
        // Observer: SalesTracker displays the Shop activity summary.
        salesTracker.summary();
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