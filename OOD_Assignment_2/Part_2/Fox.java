/*
 * Author: Caitlin Hagler
 * Class: Fox
 * Purpose: Represents the Fox animal type.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Fox extends Canine {
    public Fox() {
        super(Size.MEDIUM, "Fox");
    }
    // Fox-specific sound.
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The fox yips."
        );
    }
}