/*
 * Author: Caitlin Hagler
 * Class: Hippo
 * Purpose: Represents the Hippo animal type.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Hippo extends Pachyderm {
    public Hippo() {
        super(Size.LARGE, "Hippo");
    }
    // Hippo-specific sound.
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The hippo grunts."
        );
    }
}
