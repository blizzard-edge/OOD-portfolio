/*
 * Author: Caitlin Hagler
 * Class: Cheetah
 * Purpose: Represents the Cheetah animal type.
 * IDE: BlueJ
 * Last Revision Date: September 3, 2026
 */

public class Cheetah extends Feline {
    public Cheetah() {
        super(Size.MEDIUM, "Cheetah");
    }
    //Cheetah-specific sound.  
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The cheetah chirps."
        );
    }
}