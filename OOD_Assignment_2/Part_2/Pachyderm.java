/*
 * Author: Caitlin Hagler
 * Class: Pachyderm
 * Purpose: Abstract family class implementing pachyderm-specific roaming.
 * Last Revision Date: September 2, 2026
 */

public abstract class Pachyderm extends Animal {

    protected Pachyderm(Size size, String typeName) {
        super(size, typeName);
    }

    /*
     * Pachyderms have a 25% chance to charge while roaming.
     */
  
    @Override
    public void roam() {

        if (Math.random() < 0.25) {
            System.out.println(
                    getName() + " is roaming – and charged!"
            );
        }
        else {
            System.out.println(
                    getName() + " is roaming."
            );
        }
    }
}