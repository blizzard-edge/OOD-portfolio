/*
 * Author: Caitlin Hagler
 * Class: Bird
 * Purpose: Abstract family class implementing bird roaming behavior.
 * Last Revision Date: September 1, 2026
 */

public abstract class Bird extends Animal {

    protected Bird(Size size, String typeName) {
        super(size, typeName);
    }

    /*
     * Birds use the common roaming behavior.
     */
  
    @Override
    public void roam() {
        System.out.println(
                getName() + " is roaming."
        );
    }
}
