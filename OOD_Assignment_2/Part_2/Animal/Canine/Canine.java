/*
 * Author: Caitlin Hagler
 * Class: Canine
 * Purpose: Abstract family class implementing canine roaming behavior.
 * Last Revision Date: September 1, 2026
 */

public abstract class Canine extends Animal {

    protected Canine(Size size, String typeName) {
        super(size, typeName);
    }

    /*
     * Canines use the common roaming behavior.
     */
  
    @Override
    public void roam() {
        System.out.println(
                getName() + " is roaming."
        );
    }
}
