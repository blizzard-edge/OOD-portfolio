/*
 * Author: Caitlin Hagler
 * Class: Staff
 * Purpose: Abstract base class for Zoo employees.
 * Last Revision Date: September 2, 2026
 */

public abstract class Staff {

    private final String name;

    /*
     * Constructs a staff member and generates a unique name.
     *
     * @param roleName staff role
     */
  
    protected Staff(String roleName) {
        this.name = NameGenerator.nextStaffName(roleName);
    }

    /*
     * Gets the staff member's name.
     *
     * @return staff name
     */
  
    public String getName() {
        return name;
    }
}