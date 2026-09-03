/*
 * Author: Caitlin Hagler
 * Class: Tiger
 * Purpose: Represents the Tiger animal type.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Tiger extends Feline {
    public Tiger() {
        super(Size.LARGE, "Tiger");
    }
    // Tiger-specific sound.
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The tiger roars."
        );
    }
}