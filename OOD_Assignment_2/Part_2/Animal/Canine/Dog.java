/*
 * Author: Caitlin Hagler
 * Class: Dog
 * Purpose: Represents the Dog animal type.
 * Last Revision Date: September 2, 2026
 */

public class Dog extends Canine {

    public Dog() {
        super(Size.MEDIUM, "Dog");
    }

    /*
     * Dog-specific sound.
     */
  
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The dog barks."
        );
    }
}
