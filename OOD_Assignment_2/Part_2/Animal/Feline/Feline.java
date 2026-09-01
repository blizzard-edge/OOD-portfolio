/*
 * Author: Caitlin Hagler
 * Class: Feline
 * Purpose: Abstract family class implementing feline-specific roaming.
 * Last Revision Date: September 1, 2026
 */

public abstract class Feline extends Animal {

    protected Feline(Size size, String typeName) {
        super(size, typeName);
    }

    /*
     * Felines have a 50% chance to sleep instead of roaming.
     */
  
    @Override
    public void roam() {

        if (Math.random() < 0.50) {

            System.out.println(
                    getName() +
                    " decided to sleep instead of roaming."
            );

            sleep();
        }
        else {
            System.out.println(
                    getName() + " is roaming."
            );
        }
    }

