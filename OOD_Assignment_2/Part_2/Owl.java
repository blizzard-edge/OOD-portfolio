/*
 * Author: Caitlin Hagler
 * Class: Owl
 * Purpose: Represents the Owl animal type.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Owl extends Bird {
    public Owl() {
        super(Size.MEDIUM, "Owl");
    }
    // Owl-specific sound.
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The owl hoots."
        );
    }
}