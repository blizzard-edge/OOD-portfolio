/*
 * Author: Caitlin Hagler
 * Class: Parrot
 * Purpose: Represents the Parrot animal type.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Parrot extends Bird {
    public Parrot() {
        super(Size.SMALL, "Parrot");
    }
    // Parrot-specific sound. 
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The parrot squawks."
        );
    }
}