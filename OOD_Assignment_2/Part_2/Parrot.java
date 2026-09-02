/*
 * Author: Caitlin Hagler
 * Class: Parrot
 * Purpose: Represents the Parrot animal type.
 * Last Revision Date: September 2, 2026
 */

public class Parrot extends Bird {

    public Parrot() {
        super(Size.SMALL, "Parrot");
    }

    /*
     * Parrot-specific sound.
     */
  
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The parrot squawks."
        );
    }
}