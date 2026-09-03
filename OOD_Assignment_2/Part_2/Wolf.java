/*
 * Author: Caitlin Hagler
 * Class: Wolf
 * Purpose: Represents the Wolf animal type.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Wolf extends Canine {
    public Wolf() {
        super(Size.LARGE, "Wolf");
    }
    // Wolf-specific sound. 
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The wolf howls."
        );
    }
}