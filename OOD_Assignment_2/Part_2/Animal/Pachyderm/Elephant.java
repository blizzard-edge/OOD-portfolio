/*
 * Author: Caitlin Hagler
 * Class: Elephant
 * Purpose: Represents the Elephant animal type.
 * Last Revision Date: September 2, 2026
 */

public class Elephant extends Pachyderm {

    public Elephant() {
        super(Size.EXTRALARGE, "Elephant");
    }

    /*
     * Elephant-specific sound.
     */
  
    @Override
    public void makeSound() {
        System.out.println(
                getName() + " makes a sound: The elephant trumpets loudly."
        );
    }
}
