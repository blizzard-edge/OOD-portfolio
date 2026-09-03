/*
 * Author: Caitlin Hagler
 * Class: Wolf
 * Purpose: Represents the Wolf animal type.
 * Last Revision Date: September 2, 2026
 */

public class Wolf extends Canine {
    public Wolf() {
        super(Size.LARGE, "Wolf");
    }
    /*
     * Wolf-specific sound.
     */  
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The wolf howls."
        );
    }
}