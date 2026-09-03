/*
 * Author: Caitlin Hagler
 * Class: Lion
 * Purpose: Represents the Lion animal type.
 * Last Revision Date: September 2, 2026
 */

public class Lion extends Feline {
    public Lion() {
        super(Size.LARGE, "Lion");
    }
    /*
     * Lion-specific sound.
     */  
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The lion roars."
        );
    }
}