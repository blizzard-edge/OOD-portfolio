/*
 * Author: Caitlin Hagler
 * Class: Parrot
 * Purpose: Represents the Parrot animal type.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 */

public class Parrot extends Bird {
     private static final String[] PHRASES = {
        "Hello!",
        "Pretty bird!",
        "Who's a good bird?",
        "Polly wants a cracker!",
        "Good morning!"
    };
    public Parrot() {
        super(Size.SMALL, "Parrot");
    }
    // Parrot-specific sound. 
    @Override
    public void makeSound() {
        // Selects one of five phrases randomly.
         int index =
                (int) (Math.random() * PHRASES.length);

        
        System.out.println(
                getName() + " says: " + PHRASES[index]
        );
    }
}