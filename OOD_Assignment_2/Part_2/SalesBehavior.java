/*
 * Author: Caitlin Hagler
 * Class: SalesBehavior
 * Purpose: Defines the Strategy interface for Vendor sales behavior.
 * IDE: BlueJ
 * Last Revision Date: September 15, 2026
 *
 * Design Pattern: Strategy
 *
 * Different SalesBehavior implementations modify the Shop's
 * normal sale likelihood and visitor exit chance.
 */

public interface SalesBehavior {
    /*
     * Gets the multiplier applied to a Shop's sale likelihood.
     *
     * @return sale likelihood multiplier
     */
    double getSaleModifier();
    /*
     * Gets the additional exit chance caused by the Vendor.
     *
     * @return additional exit chance
     */
    double getExitModifier();
}