/*
 * Author: Caitlin Hagler
 * Class: Falcon
 * Purpose: Represents the Falcon animal type.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Falcon extends Bird {
    public Falcon() {
        super(Size.MEDIUM, "Falcon");
    }
    // Falcon-specific sound.  
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The falcon screeches."
        );
    }
}