/*
 * Author: Caitlin Hagler
 * Class: Cheetah
 * Purpose: Represents the Cheetah animal type.
 * Last Revision Date: September 2, 2026
 */

public class Cheetah extends Feline {
    public Cheetah() {
        super(Size.MEDIUM, "Cheetah");
    }
    /*
     * Cheetah-specific sound.
     */  
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The cheetah chirps."
        );
    }
}