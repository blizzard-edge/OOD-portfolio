/*
 * Author: Caitlin Hagler
 * Class: Tiger
 * Purpose: Represents the Tiger animal type.
 * Last Revision Date: September 2, 2026
 */

public class Tiger extends Feline {

    public Tiger() {
        super(Size.LARGE, "Tiger");
    }

    /*
     * Tiger-specific sound.
     */
  
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The tiger roars."
        );
    }
}
