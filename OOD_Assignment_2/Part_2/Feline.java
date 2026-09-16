/*
 * Author: Caitlin Hagler
 * Class: Feline
 * Purpose: Abstract family class implementing feline-specific roaming.
 * IDE: BlueJ
 * Last Revision Date: September 16, 2026
 */

public abstract class Feline extends Animal {
    protected Feline(Size size, String typeName) {
        super(size, typeName);
    }
    /*
     * Felines have a 50% chance to sleep instead of roaming. 
     * When they roam, they have a 10% chance to charge.
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
        else if (Math.random() < 0.10) {
            System.out.println(
                getName() + 
                " is roaming, and has charged!"
            );
        }
        else {
            System.out.println(
                    getName() + " is roaming."
            );
        }
    }
}