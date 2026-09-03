/*
 * Author: Caitlin Hagler
 * Class: Rhino
 * Purpose: Represents the Rhino animal type.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Rhino extends Pachyderm {
    public Rhino() {
        super(Size.LARGE, "Rhino");
    }
    // Rhino-specific sound.   
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The rhino snorts."
        );
    }
}