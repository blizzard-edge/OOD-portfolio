/*
 * Author: Caitlin Hagler
 * Class: NameGenerator
 * Purpose: Generates unique names for Animal and Staff objects.
 * Last Revision Date: September 2, 2026
 */

public final class NameGenerator {
    private static int animalNumber = 1;
    private static int staffNumber = 1;
    /*
     * Private constructor prevents creation of NameGenerator objects.
     * The class only provides static naming methods.
     */  
    private NameGenerator() {
    }
    /*
     * Generates a unique name for an Animal.
     *
     * @param typeName the animal's type
     * @return a unique animal name
     */  
    public static String nextAnimalName(String typeName) {
        return typeName + " " + animalNumber++;
    }
    /*
     * Generates a unique name for a Staff member.
     *
     * @param roleName the staff member's role
     * @return a unique staff name
     */
    public static String nextStaffName(String roleName) {
        return roleName + " " + staffNumber++;
    }
}