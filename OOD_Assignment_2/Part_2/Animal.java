/*
 * Author: Caitlin Hagler
 * Class: Animal
 * Purpose: Abstract base class containing state and behavior common to all animals.
 * Last Revision Date: September 2, 2026
 */

public abstract class Animal {

    private final String name;
    private final Size size;
    private boolean healthy;
    private final String typeName;

    /*
     * Constructs an Animal.
     *
     * @param size the animal's size
     * @param typeName the animal's concrete type
     */
  
    protected Animal(Size size, String typeName) {
        this.name = NameGenerator.nextAnimalName(typeName);
        this.size = size;
        this.typeName = typeName;
        this.healthy = true;
    }

    /*
     * Gets the animal's unique name.
     *
     * @return animal name
     */
  
    public String getName() {
        return name;
    }

    /*
     * Gets the animal's size.
     *
     * @return animal size
     */
  
    public Size getSize() {
        return size;
    }

    /*
     * Gets the concrete animal type.
     *
     * @return animal type
     */
  
    public String getTypeName() {
        return typeName;
    }

    /*
     * Checks whether the animal is healthy.
     *
     * @return true if healthy
     */
  
    public boolean isHealthy() {
        return healthy;
    }

    /*
     * Changes the animal's health status.
     *
     * @param healthy new health status
     */
  
    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    /*
     * Common behavior shared by every animal.
     */
  
    public void sleep() {
        System.out.println(name + " has gone to sleep.");
    }

    /*
     * Common feeding behavior.
     *
     * There is a 10% chance of eating 0 food units,
     * a 10% chance of eating too much,
     * and an 80% chance of eating normally.
     *
     * @return the number of food units eaten
     */
  
    public int eat() {

        int roll = (int) (Math.random() * 10);
        int foodUnits;

        if (roll == 0) {
            // 10% chance
            foodUnits = 0;
        }
        else if (roll == 1) {
            // 10% chance
            foodUnits = 3;
        }
        else {
            // 80% chance
            foodUnits = 1;
        }

        System.out.println(
                name + " is eating " + foodUnits + " food units."
        );

        return foodUnits;
    }

    /*
     * Family-specific roaming behavior.
     * Each animal family provides its own implementation.
     */
  
    public abstract void roam();

    /*
     * Each concrete animal type provides its own sound.
     */
  
    public abstract void makeSound();
}